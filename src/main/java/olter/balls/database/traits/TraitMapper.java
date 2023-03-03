package olter.balls.database.traits;

import olter.balls.common.NameResponse;
import olter.balls.database.importer.dto.TraitImport;
import olter.balls.database.traits.dto.TraitListResponse;
import olter.balls.database.traits.model.TraitCategoryEnum;
import olter.balls.database.traits.model.TraitEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TraitMapper {
  NameResponse entityToNameResponse(TraitEntity entity);

  TraitListResponse entityToListResponse(TraitEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "description", ignore = true)
  @Mapping(target = "relatedActions", ignore = true)
  @Mapping(target = "relatedAncestries", ignore = true)
  TraitEntity map(TraitImport source, @MappingTarget TraitEntity target);

  @ValueMapping(source = "Ancestry & Heritage", target = "ANCESTRY")
  @ValueMapping(source = "Action & Ability", target = "ACTION")
  @ValueMapping(source = "Creature", target = "CREATURE_TYPE")
  @ValueMapping(source = "Creature Type", target = "CREATURE_TYPE")
  @ValueMapping(source = "Energy & Element", target = "ENERGY")
  @ValueMapping(source = MappingConstants.ANY_REMAINING, target = "GENERAL")
  @EnumMapping(nameTransformationStrategy = "case", configuration = "capital")
  TraitCategoryEnum categoryToEnum(String category);
}
