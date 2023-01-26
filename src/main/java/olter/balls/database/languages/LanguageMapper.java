package olter.balls.database.languages;

import olter.balls.database.books.BookEntity;
import olter.balls.database.books.dto.BookResponse;
import olter.balls.database.core.enums.LanguageTypeEnum;
import olter.balls.database.languages.dto.LanguageResponse;
import org.mapstruct.EnumMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    LanguageResponse entityToResponse(LanguageEntity entity);
    List<LanguageResponse> entityToResponseList(List<LanguageEntity> entities);
}
