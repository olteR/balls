package olter.balls.database.spells;

import olter.balls.common.NameResponse;
import olter.balls.database.core.enums.SpellTraditionEnum;
import olter.balls.database.importer.dto.spell.SpellImport;
import olter.balls.database.spells.model.SpellEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SpellMapper {
  NameResponse entityToNameResponse(SpellEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "traits", ignore = true)
  @Mapping(target = "description", ignore = true)
  @Mapping(target = "activity", ignore = true)
  @Mapping(target = "components", ignore = true)
  SpellEntity map(SpellImport source, @MappingTarget SpellEntity target);

  @EnumMapping(nameTransformationStrategy = "case", configuration = "lower")
  SpellTraditionEnum toTraditionEnum(String tradition);
}
