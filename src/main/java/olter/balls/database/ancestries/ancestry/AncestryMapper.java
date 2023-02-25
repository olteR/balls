package olter.balls.database.ancestries.ancestry;

import olter.balls.common.NameResponse;
import olter.balls.database.ancestries.ancestry.dto.AncestryDetailsResponse;
import olter.balls.database.ancestries.ancestry.dto.AncestryListResponse;
import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import olter.balls.database.ancestries.ancestry.model.AncestryRarityEnum;
import olter.balls.database.core.enums.CreatureSizeEnum;
import olter.balls.database.importer.dto.ancestry.AncestryImport;
import org.mapstruct.EnumMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AncestryMapper {
  AncestryDetailsResponse entityToDetailsResponse(AncestryEntity entity);

  AncestryListResponse entityToListResponse(AncestryEntity entity);

  NameResponse entityToNameResponse(AncestryEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "traits", ignore = true)
  @Mapping(target = "additionalLanguages", ignore = true)
  @Mapping(target = "description", ignore = true)
  @Mapping(target = "abilityBoosts", ignore = true)
  @Mapping(target = "characters", ignore = true)
  @Mapping(target = "knownLanguages", ignore = true)
  @Mapping(target = "heritages", ignore = true)
  @Mapping(target = "speed.walking", source = "speed.walk")
  @Mapping(target = "speed.swimming", source = "speed.swim")
  AncestryEntity map(AncestryImport source, @MappingTarget AncestryEntity target);

  @EnumMapping(nameTransformationStrategy = "case", configuration = "lower")
  CreatureSizeEnum sizeToEnum(String size);

  @EnumMapping(nameTransformationStrategy = "case", configuration = "lower")
  AncestryRarityEnum rarityToEnum(String size);
}
