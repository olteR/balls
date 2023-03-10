package olter.balls.database.actions.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.NameResponse;
import olter.balls.common.exception.ResourceNotFoundException;
import olter.balls.database.actions.ActionMapper;
import olter.balls.database.actions.model.ActionEntity;
import olter.balls.database.actions.model.ActionRepository;
import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import olter.balls.database.ancestries.ancestry.model.AncestryRepository;
import olter.balls.database.ancestries.heritage.model.HeritageEntity;
import olter.balls.database.ancestries.heritage.model.HeritageRepository;
import olter.balls.database.importer.ImporterUtils;
import olter.balls.database.importer.dto.ImportResponse;
import olter.balls.database.importer.dto.action.ActionImport;
import olter.balls.database.traits.controller.TraitService;
import olter.balls.database.traits.model.TraitEntity;
import olter.balls.database.traits.model.TraitRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActionService {
  private final ActionRepository actionRepository;
  private final ActionMapper actionMapper;

  private final AncestryRepository ancestryRepository;
  private final HeritageRepository heritageRepository;

  private final TraitService traitService;

  public ImportResponse processImports(ActionImport[] imports) {
    List<NameResponse> importedActions = new ArrayList<>();
    List<NameResponse> updatedActions = new ArrayList<>();
    for (ActionImport action : imports) {
      Optional<ActionEntity> oEntity = actionRepository.findByName(action.getName());
      log.info(
          oEntity.isPresent()
              ? "Updating " + action.getName() + "..."
              : "Importing " + action.getName() + "...");
      ActionEntity entity = oEntity.orElseGet(ActionEntity::new);
      actionMapper.map(action, entity);

      // ACTIVITY
      entity.setActivity(ImporterUtils.mapActivity(action.getActivity()));

      // FREQUENCY
      entity.setFrequency(actionMapper.importToEmbeddable(action.getFrequency()));

      // TRAITS
      entity.setTraits(traitService.getTraitsFromStrings(action.getTraits()));

      // ANCESTRIES & HERITAGES
      if (action.getActionType() != null && action.getActionType().getAncestry() != null) {
        String[] ancestryString = action.getActionType().getAncestry().get(0).split("\\|");
        AncestryEntity ancestry =
            ancestryRepository
                .findByName(ancestryString[0])
                .orElseThrow(
                    () ->
                        new ResourceNotFoundException(
                            AncestryEntity.class.getName(), ancestryString[0]));
        if (action.getActionType().getHeritage() != null) {
          String[] heritageString = action.getActionType().getHeritage().get(0).split("\\|");
          HeritageEntity heritage =
              heritageRepository
                  .findByAncestryAndShortName(ancestry, heritageString[0])
                  .orElseThrow(
                      () ->
                          new ResourceNotFoundException(
                              AncestryEntity.class.getName(), ancestryString[0]));
          entity.setRelatedHeritage(heritage);
        } else {
          entity.setRelatedAncestry(ancestry);
        }
      }

      actionRepository.save(entity);

      if (oEntity.isPresent()) updatedActions.add(actionMapper.entityToNameResponse(entity));
      else importedActions.add(actionMapper.entityToNameResponse(entity));
    }
    log.info("Imported " + importedActions.size() + " actions");
    log.info("Updated " + updatedActions.size() + " actions");
    return new ImportResponse(importedActions, updatedActions);
  }
}
