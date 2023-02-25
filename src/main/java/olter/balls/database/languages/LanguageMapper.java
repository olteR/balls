package olter.balls.database.languages;

import olter.balls.common.NameResponse;
import olter.balls.database.importer.dto.LanguageImport;
import olter.balls.database.languages.dto.LanguageDetailsResponse;
import olter.balls.database.languages.dto.LanguageListResponse;
import olter.balls.database.languages.model.LanguageEntity;
import olter.balls.database.languages.model.LanguageTypeEnum;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
  NameResponse entityToNameResponse(LanguageEntity entity);

  LanguageDetailsResponse entityToDetailsResponse(LanguageEntity entity);

  LanguageListResponse entityToListResponse(LanguageEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "description", ignore = true)
  @Mapping(target = "typicalSpeakers", ignore = true)
  @Mapping(target = "ancestriesKnowing", ignore = true)
  LanguageEntity map(LanguageImport source, @MappingTarget LanguageEntity target);

  @EnumMapping(nameTransformationStrategy = "case", configuration = "capital")
  @ValueMapping(source = MappingConstants.ANY_REMAINING, target = "COMMON")
  LanguageTypeEnum typeToEnum(String type);
}
