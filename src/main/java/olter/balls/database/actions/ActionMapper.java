package olter.balls.database.actions;

import olter.balls.common.NameResponse;
import olter.balls.database.actions.model.ActionEntity;
import olter.balls.database.core.embeddables.FrequencyEmbeddable;
import olter.balls.database.core.enums.FrequencyUnitEnum;
import olter.balls.database.importer.dto.action.ActionImport;
import olter.balls.database.importer.dto.action.FrequencyImport;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ActionMapper {

  NameResponse entityToNameResponse(ActionEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "activity", ignore = true)
  @Mapping(target = "frequency", ignore = true)
  @Mapping(target = "traits", ignore = true)
  @Mapping(target = "basic", source = "actionType.basic")
  ActionEntity map(ActionImport source, @MappingTarget ActionEntity target);

  @Mapping(target = "frequency", source = "freq")
  @Mapping(target = "timespan", source = "unit")
  FrequencyEmbeddable importToEmbeddable(FrequencyImport frequency);

  @EnumMapping(nameTransformationStrategy = "case", configuration = "lower")
  FrequencyUnitEnum sizeToEnum(String size);
}
