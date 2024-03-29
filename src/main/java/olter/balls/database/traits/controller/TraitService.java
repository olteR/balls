package olter.balls.database.traits.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.NameResponse;
import olter.balls.common.exception.ResourceNotFoundException;
import olter.balls.database.importer.ImporterUtils;
import olter.balls.database.importer.dto.ImportResponse;
import olter.balls.database.importer.dto.TraitImport;
import olter.balls.database.traits.TraitMapper;
import olter.balls.database.traits.dto.TraitListResponse;
import olter.balls.database.traits.model.TraitCategoryEnum;
import olter.balls.database.traits.model.TraitEntity;
import olter.balls.database.traits.model.TraitRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TraitService {
  private final List<String> ABILITIES =
      Arrays.asList("Deviant", "Esoterica", "Psyche", "Instinct");
  private final List<String> ELEMENTS = Arrays.asList("Air", "Earth", "Fire", "Water");

  private final TraitRepository traitRepository;
  private final TraitMapper traitMapper;

  public TraitListResponse getTrait(Integer id) {
    Optional<TraitEntity> entity = traitRepository.findById(id);
    if (entity.isPresent()) {
      return traitMapper.entityToListResponse(entity.get());
    } else throw new ResourceNotFoundException(TraitEntity.class.getName(), id);
  }

  public List<TraitListResponse> getTraits() {
    return traitRepository.findAll().stream().map(traitMapper::entityToListResponse).toList();
  }

  public ImportResponse processImports(TraitImport[] imports) {
    List<NameResponse> importedTraits = new ArrayList<>();
    List<NameResponse> updatedTraits = new ArrayList<>();
    for (TraitImport trait : imports) {
      if ((trait.getCategories() == null
              || (!trait.getCategories().contains("_alignAbv")
                  && !trait.getCategories().contains("Size")))
          && !trait.getName().startsWith("[")) {
        Optional<TraitEntity> oEntity = traitRepository.findByName(trait.getName());
        log.info(
            oEntity.isPresent()
                ? "Updating " + trait.getName() + "..."
                : "Importing " + trait.getName() + "...");
        TraitEntity entity = oEntity.orElseGet(TraitEntity::new);
        traitMapper.map(trait, entity);
        entity.setDescription(ImporterUtils.toHtmlParagraphs(trait.getEntries(), true));
        if (ABILITIES.contains(entity.getName())) {
          entity
              .getCategories()
              .set(
                  entity.getCategories().indexOf(TraitCategoryEnum.ACTION),
                  TraitCategoryEnum.ABILITY);
        } else if (ELEMENTS.contains(entity.getName())) {
          entity
              .getCategories()
              .set(
                  entity.getCategories().indexOf(TraitCategoryEnum.ENERGY),
                  TraitCategoryEnum.ELEMENT);
        }
        traitRepository.save(entity);
        if (oEntity.isPresent()) updatedTraits.add(traitMapper.entityToNameResponse(entity));
        else importedTraits.add(traitMapper.entityToNameResponse(entity));
      }
    }
    log.info("Imported " + importedTraits.size() + " traits");
    log.info("Updated " + updatedTraits.size() + " traits");
    return new ImportResponse(importedTraits, updatedTraits);
  }

  public List<TraitEntity> getTraitsFromStrings(List<String> input) {
    if (input != null) {
      List<TraitEntity> traits = new ArrayList<>();
      input.forEach(
          t -> {
            Optional<TraitEntity> trait = traitRepository.findByName(t);
            trait.ifPresent(traits::add);
          });
      return traits;
    }
    return null;
  }
}
