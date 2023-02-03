package olter.balls.database.languages;

import olter.balls.common.NameResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    NameResponse entityToNameResponse(LanguageEntity entity);
    List<NameResponse> entityToNameResponseList(List<LanguageEntity> entities);
}
