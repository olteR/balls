package olter.balls.database.languages;

import olter.balls.common.NameResponse;
import olter.balls.database.languages.dto.LanguageDetailsResponse;
import olter.balls.database.languages.dto.LanguageListResponse;
import olter.balls.database.languages.model.LanguageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
  NameResponse entityToNameResponse(LanguageEntity entity);

  LanguageDetailsResponse entityToDetailsResponse(LanguageEntity entity);

  LanguageListResponse entityToListResponse(LanguageEntity entity);
}
