package olter.balls.database.importer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.NameResponse;
import olter.balls.database.ancestries.AncestryEntity;
import olter.balls.database.ancestries.AncestryMapper;
import olter.balls.database.ancestries.AncestryRarityEnum;
import olter.balls.database.ancestries.AncestryRepository;
import olter.balls.database.books.BookEntity;
import olter.balls.database.books.BookMapper;
import olter.balls.database.books.BookRepository;
import olter.balls.database.core.embeddables.AbilityBoostEmbeddable;
import olter.balls.database.core.embeddables.FeatureEmbeddable;
import olter.balls.database.core.enums.AbilityScoreEnum;
import olter.balls.database.importer.dto.BookImport;
import olter.balls.database.importer.dto.LanguageImport;
import olter.balls.database.importer.dto.TraitImport;
import olter.balls.database.importer.dto.ancestry.AncestryImport;
import olter.balls.database.languages.LanguageEntity;
import olter.balls.database.languages.LanguageMapper;
import olter.balls.database.languages.LanguageRepository;
import olter.balls.database.traits.TraitCategoryEnum;
import olter.balls.database.traits.TraitEntity;
import olter.balls.database.traits.TraitMapper;
import olter.balls.database.traits.TraitRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImporterService {

  @Value("${import.url}")
  private String IMPORT_URL;

  private final List<String> abilities =
      Arrays.asList("Deviant", "Esoterica", "Psyche", "Instinct");
  private final List<String> elements = Arrays.asList("Air", "Earth", "Fire", "Water");

  private final ImportMapper importMapper;

  private final AncestryRepository ancestryRepository;
  private final AncestryMapper ancestryMapper;

  private final BookMapper bookMapper;
  private final BookRepository bookRepository;

  private final LanguageMapper languageMapper;
  private final LanguageRepository languageRepository;

  private final TraitRepository traitRepository;
  private final TraitMapper traitMapper;

  public List<NameResponse> importAncestries() throws JsonProcessingException {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    ResponseEntity<String> responseJson =
        restTemplate.exchange(
            IMPORT_URL.concat("ancestries/index.json"),
            HttpMethod.GET,
            generateHttpEntity(),
            String.class);
    String[] sources = Objects.requireNonNull(responseJson.getBody()).split(",");
    List<AncestryEntity> importedAncestries = new ArrayList<>();
    for (String source : sources) {
      source = source.substring(source.indexOf(':') + 3, source.lastIndexOf('"'));
      if (!source.equals("versatile-heritages.json")) {
        ResponseEntity<String> ancestryResponseJson =
            restTemplate.exchange(
                IMPORT_URL.concat("ancestries/".concat(source)),
                HttpMethod.GET,
                generateHttpEntity(),
                String.class);
        AncestryImport ancestryImport =
            mapper.readValue(
                Objects.requireNonNull(ancestryResponseJson.getBody())
                    .substring(
                        ancestryResponseJson.getBody().indexOf('[') + 1,
                        ancestryResponseJson.getBody().lastIndexOf(']')),
                AncestryImport.class);
        AncestryEntity entity = importMapper.toAncestryEntity(ancestryImport);

        // RARITY
        if (entity.getRarity() == null) entity.setRarity(AncestryRarityEnum.COMMON);

        // ABILITY BOOSTS AND FLAWS
        List<AbilityBoostEmbeddable> abilityBoosts = new ArrayList<>();
        abilityBoosts.addAll(getBoosts(ancestryImport.getBoosts(), false));
        abilityBoosts.addAll(getBoosts(ancestryImport.getFlaw(), true));
        entity.setAbilityBoosts(abilityBoosts);

        // DESCRIPTION
        List<FeatureEmbeddable> features = new ArrayList<>();
        features.add(
            new FeatureEmbeddable(
                "Flavor",
                "<p>".concat(String.join("</p><p>", ancestryImport.getFlavor())).concat("</p>")));
        features.add(
            new FeatureEmbeddable(
                "Info",
                "<p>"
                    .concat(
                        String.join(
                            "</p><p>",
                            ancestryImport.getInfo().stream()
                                .filter(i -> i.getClass() == String.class)
                                .map(Object::toString)
                                .toList()))
                    .concat("</p>")));
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
                          "<p>"
                              .concat(
                                  entries
                                      .substring(0, entries.indexOf("]"))
                                      .replace(".,", ".</p><p>"))
                              .concat("</p>");
                      features.add(new FeatureEmbeddable(name, entries));
                    }
                  }
                });
        entity.setFeatures(features);

        // LANGUAGES
        List<LanguageEntity> languages = new ArrayList<>();
        ancestryImport
            .getLanguages()
            .forEach(
                l -> {
                  if (l.startsWith("{@language")) {
                    languages.add(
                        languageRepository.findByName(
                            l.substring(
                                l.indexOf(' ') + 1,
                                l.contains("|") ? l.indexOf('|') : l.indexOf('}'))));
                  } else {
                    try {
                      entity.setAdditionalLanguages(
                          Integer.parseInt(
                              l.substring(0, l.indexOf('.')).replaceAll("[^0-9]", "")));
                    } catch (NumberFormatException e) {
                      entity.setAdditionalLanguages(0);
                    }
                  }
                });
        entity.setKnownLanguages(languages);
        try {
          ancestryRepository.save(entity);
          importedAncestries.add(entity);

        } catch (Exception ignored) {
        }
        log.info("Imported " + entity.getName());
      }
    }
    return ancestryMapper.entityToNameResponseList(importedAncestries);
  }

  public List<NameResponse> importBooks() throws JsonProcessingException {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    ResponseEntity<String> responseJson =
        restTemplate.exchange(
            IMPORT_URL.concat("books.json"), HttpMethod.GET, generateHttpEntity(), String.class);
    BookImport[] imports =
        mapper.readValue(
            Objects.requireNonNull(responseJson.getBody())
                .substring(
                    responseJson.getBody().indexOf('['),
                    responseJson.getBody().lastIndexOf(']') + 1),
            BookImport[].class);
    ArrayList<BookEntity> importedBooks = new ArrayList<>();
    for (BookImport book : imports) {
      BookEntity entity = importMapper.toBookEntity(book);
      try {
        bookRepository.save(entity);
        importedBooks.add(entity);
      } catch (Exception ignored) {
      }
    }
    log.info("Imported " + importedBooks.size() + " books");
    return bookMapper.entityToNameResponseList(importedBooks);
  }

  public List<NameResponse> importLanguages() throws JsonProcessingException {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    ResponseEntity<String> responseJson =
        restTemplate.exchange(
            IMPORT_URL.concat("languages.json"),
            HttpMethod.GET,
            generateHttpEntity(),
            String.class);
    LanguageImport[] imports =
        mapper.readValue(
            Objects.requireNonNull(responseJson.getBody())
                .substring(
                    responseJson.getBody().indexOf('['),
                    responseJson.getBody().lastIndexOf(']') + 1),
            LanguageImport[].class);
    ArrayList<LanguageEntity> importedLanguages = new ArrayList<>();
    for (LanguageImport lang : imports) {
      LanguageEntity entity = importMapper.toLanguageEntity(lang);
      try {
        languageRepository.save(entity);
        importedLanguages.add(entity);
      } catch (Exception ignored) {
      }
    }
    log.info("Imported " + importedLanguages.size() + " languages");
    return languageMapper.entityToNameResponseList(importedLanguages);
  }

  public List<NameResponse> importTraits() throws JsonProcessingException {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    ResponseEntity<String> responseJson =
        restTemplate.exchange(
            IMPORT_URL.concat("traits.json"), HttpMethod.GET, generateHttpEntity(), String.class);
    TraitImport[] imports =
        mapper.readValue(
            Objects.requireNonNull(responseJson.getBody())
                .substring(
                    responseJson.getBody().indexOf('['),
                    responseJson.getBody().lastIndexOf(']') + 1),
            TraitImport[].class);
    ArrayList<TraitEntity> importedTraits = new ArrayList<>();
    for (TraitImport trait : imports) {
      if ((trait.getCategories() == null
              || (!trait.getCategories().contains("_alignAbv")
                  && !trait.getCategories().contains("Size")))
          && !trait.getName().startsWith("[")) {
        TraitEntity entity = importMapper.toTraitEntity(trait);
        String description = "";
        for (Object entry : trait.getEntries()) {
          if (entry instanceof String) {
            description = description.concat("\n").concat((String) entry);
          }
        }
        entity.setDescription(description);
        if (abilities.contains(entity.getName())) {
          entity.setCategories(
              mapTraits(entity, TraitCategoryEnum.ACTION, TraitCategoryEnum.ABILITY));
        } else if (elements.contains(entity.getName())) {
          entity.setCategories(
              mapTraits(entity, TraitCategoryEnum.ENERGY, TraitCategoryEnum.ELEMENT));
        }
        try {
          traitRepository.save(entity);
          importedTraits.add(entity);
        } catch (Exception ignored) {
        }
      }
    }
    log.info("Imported " + importedTraits.size() + " traits");
    return traitMapper.entityToNameResponseList(importedTraits);
  }

  private HttpEntity<String> generateHttpEntity() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("user-agent", "Application");
    headers.setAccept(List.of(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_JSON);
    return new HttpEntity<>(headers);
  }

  private List<TraitCategoryEnum> mapTraits(
      TraitEntity entity, TraitCategoryEnum from, TraitCategoryEnum to) {
    return entity.getCategories().stream()
        .map(
            category -> {
              if (category == from) return to;
              return category;
            })
        .toList();
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
