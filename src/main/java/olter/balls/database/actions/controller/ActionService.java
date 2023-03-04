package olter.balls.database.actions.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.NameResponse;
import olter.balls.database.actions.ActionMapper;
import olter.balls.database.actions.model.ActionEntity;
import olter.balls.database.actions.model.ActionRepository;
import olter.balls.database.importer.ImporterUtils;
import olter.balls.database.importer.dto.ImportResponse;
import olter.balls.database.importer.dto.action.ActionImport;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActionService {
  private final ActionRepository actionRepository;
  private final ActionMapper actionMapper;

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

      actionRepository.save(entity);

      if (oEntity.isPresent()) updatedActions.add(actionMapper.entityToNameResponse(entity));
      else importedActions.add(actionMapper.entityToNameResponse(entity));
    }
    log.info("Imported " + importedActions.size() + " actions");
    log.info("Updated " + updatedActions.size() + " actions");
    return new ImportResponse(importedActions, updatedActions);
  }
}
