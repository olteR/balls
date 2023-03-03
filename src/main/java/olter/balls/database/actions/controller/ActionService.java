package olter.balls.database.actions.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.NameResponse;
import olter.balls.database.actions.ActionMapper;
import olter.balls.database.actions.model.ActionEntity;
import olter.balls.database.actions.model.ActionRepository;
import olter.balls.database.importer.dto.ImportResponse;
import olter.balls.database.importer.dto.action.ActionImport;
import olter.balls.database.languages.model.LanguageEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        }
        return new ImportResponse();
    }
}
