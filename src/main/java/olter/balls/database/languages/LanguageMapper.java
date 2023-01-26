package olter.balls.database.languages;

import olter.balls.database.languages.dto.LanguageResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    LanguageResponse entityToResponse(LanguageEntity entity);
    List<LanguageResponse> entityToResponseList(List<LanguageEntity> entities);
}
