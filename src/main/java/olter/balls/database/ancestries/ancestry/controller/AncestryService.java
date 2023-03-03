package olter.balls.database.ancestries.ancestry.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.NameResponse;
import olter.balls.common.exception.ResourceNotFoundException;
import olter.balls.database.ancestries.ancestry.AncestryMapper;
import olter.balls.database.ancestries.ancestry.dto.AncestryDetailsResponse;
import olter.balls.database.ancestries.ancestry.dto.AncestryListResponse;
import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import olter.balls.database.ancestries.ancestry.model.AncestryRarityEnum;
import olter.balls.database.ancestries.ancestry.model.AncestryRepository;
import olter.balls.database.ancestries.heritage.controller.HeritageService;
import olter.balls.database.core.embeddables.AbilityBoostEmbeddable;
import olter.balls.database.core.embeddables.FeatureEmbeddable;
import olter.balls.database.core.enums.AbilityScoreEnum;
import olter.balls.database.importer.ImporterUtils;
import olter.balls.database.importer.dto.ImportResponse;
import olter.balls.database.importer.dto.ancestry.AncestryImport;
import olter.balls.database.importer.dto.ancestry.AncestryImportResponse;
import olter.balls.database.languages.model.LanguageEntity;
import olter.balls.database.languages.model.LanguageRepository;
import olter.balls.database.traits.model.TraitEntity;
import olter.balls.database.traits.model.TraitRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AncestryService {
  private final AncestryRepository ancestryRepository;
  private final AncestryMapper ancestryMapper;

  private final LanguageRepository languageRepository;
  private final TraitRepository traitRepository;

  private final HeritageService heritageService;

  public AncestryDetailsResponse getAncestry(Long id) {
    Optional<AncestryEntity> entity = ancestryRepository.findById(id);
    if (entity.isPresent()) {
      return ancestryMapper.entityToDetailsResponse(entity.get());
    } else throw new ResourceNotFoundException("no ancestry with such id");
  }

  public List<AncestryListResponse> getAncestries() {
    return ancestryRepository.findAll().stream().map(ancestryMapper::entityToListResponse).toList();
  }

  public AncestryImportResponse processImports(List<AncestryImport> imports) {
    List<NameResponse> importedAncestries = new ArrayList<>();
    List<NameResponse> updatedAncestries = new ArrayList<>();
    ImportResponse heritages = new ImportResponse();
    for (AncestryImport ancestryImport : imports) {
      Optional<AncestryEntity> oEntity = ancestryRepository.findByName(ancestryImport.getName());
      log.info(
          oEntity.isPresent()
              ? "Updating " + ancestryImport.getName() + "..."
              : "Importing " + ancestryImport.getName() + "...");
      AncestryEntity entity = oEntity.orElseGet(AncestryEntity::new);
      ancestryMapper.map(ancestryImport, entity);

      // RARITY
      if (entity.getRarity() == null) {
        entity.setRarity(AncestryRarityEnum.COMMON);
        log.info("null");
      };

      // ABILITY BOOSTS AND FLAWS
      List<AbilityBoostEmbeddable> abilityBoosts = new ArrayList<>();
      abilityBoosts.addAll(getBoosts(ancestryImport.getBoosts(), false));
      abilityBoosts.addAll(getBoosts(ancestryImport.getFlaw(), true));
      entity.setAbilityBoosts(abilityBoosts);

      // DESCRIPTION
      List<FeatureEmbeddable> features = new ArrayList<>();
      features.add(
          new FeatureEmbeddable(
              "Flavor", ImporterUtils.toHtmlParagraphs(ancestryImport.getFlavor(), false)));
      features.add(
          new FeatureEmbeddable(
              "Info", ImporterUtils.toHtmlParagraphs(ancestryImport.getInfo(), true)));
      ancestryImport.getInfo().stream()
          .filter(i -> i.getClass() != String.class)
          .forEach(
              i -> {
                String info = i.toString();
                if (info.contains("entries=[") && info.contains("name=")) {
                  String name = info.substring(info.indexOf("name=") + 5);
                  name = name.substring(0, name.indexOf(','));
                  String entries = info.substring(info.indexOf("entries=[") + 9);
                  if (entries.contains("{type=list")) {
                    entries = entries.substring(entries.indexOf("items=[") + 7);
                    entries =
                        "<ul><li>"
                            .concat(
                                entries
                                    .substring(0, entries.indexOf("]"))
                                    .replace(".,", ".</li><li>"))
                            .concat("</li></ul>");
                    features.add(new FeatureEmbeddable(name, entries));
                  } else if (!entries.contains("{type=")) {
                    entries =
                        ImporterUtils.wrapParagraph(
                            entries.substring(0, entries.indexOf("]")).replace(".,", ".</p><p>"));
                    features.add(new FeatureEmbeddable(name, entries));
                  }
                }
              });
      entity.setDescription(features);

      // LANGUAGES
      List<LanguageEntity> languages = new ArrayList<>();
      ancestryImport
          .getLanguages()
          .forEach(
              l -> {
                if (l.startsWith("{@language")) {
                  Optional<LanguageEntity> language =
                      languageRepository.findByName(
                          l.substring(
                              l.indexOf(' ') + 1,
                              l.contains("|") ? l.indexOf('|') : l.indexOf('}')));
                  language.ifPresent(languages::add);
                } else {
                  try {
                    entity.setAdditionalLanguages(
                        Long.valueOf(l.substring(0, l.indexOf('.')).replaceAll("[^0-9]", "")));
                  } catch (NumberFormatException e) {
                    entity.setAdditionalLanguages(0L);
                  }
                }
              });
      entity.setKnownLanguages(languages);

      // TRAITS
      List<TraitEntity> traits = new ArrayList<>();
      ancestryImport
          .getTraits()
          .forEach(
              t -> {
                Optional<TraitEntity> trait = traitRepository.findByName(t);
                trait.ifPresent(traits::add);
              });
      entity.setTraits(traits);

      ancestryRepository.save(entity);

      // HERITAGES
      ImportResponse currentHeritages =
          heritageService.processImports(ancestryImport.getHeritages(), entity);
      heritages.getImported().addAll(currentHeritages.getImported());
      heritages.getUpdated().addAll(currentHeritages.getUpdated());

      if (oEntity.isPresent()) updatedAncestries.add(ancestryMapper.entityToNameResponse(entity));
      else importedAncestries.add(ancestryMapper.entityToNameResponse(entity));
    }

    log.info("Imported " + importedAncestries.size() + " ancestries");
    log.info("Updated " + updatedAncestries.size() + " ancestries");
    log.info("Imported " + heritages.getImported().size() + " heritages");
    log.info("Updated " + heritages.getUpdated().size() + " heritages");
    return new AncestryImportResponse(importedAncestries, updatedAncestries, heritages);
  }

  private List<AbilityBoostEmbeddable> getBoosts(List<String> boosts, boolean flaw) {
    List<AbilityBoostEmbeddable> abilityBoosts = new ArrayList<>();
    if (boosts != null) {
      for (String boost : boosts) {
        AbilityBoostEmbeddable abilityBoost =
            new AbilityBoostEmbeddable(
                boost.contains("free")
                    ? null
                    : AbilityScoreEnum.valueOf(boost.substring(0, 3).toUpperCase()),
                boost.contains("free"),
                flaw);
        if (boost.equals("Two free ability boosts")) {
          abilityBoosts.add(new AbilityBoostEmbeddable(null, true, false));
        }
        abilityBoosts.add(abilityBoost);
      }
    }
    return abilityBoosts;
  }
}
