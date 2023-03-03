package olter.balls.database.actions;

import olter.balls.database.actions.model.ActionEntity;
import olter.balls.database.importer.dto.action.ActionImport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ActionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activity", ignore = true)
    @Mapping(target = "frequency", ignore = true)
    @Mapping(target = "traits", ignore = true)
    ActionEntity map(ActionImport source, @MappingTarget ActionEntity target);
}
