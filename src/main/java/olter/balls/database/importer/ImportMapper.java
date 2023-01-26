package olter.balls.database.importer;

import olter.balls.database.books.BookEntity;
import olter.balls.database.core.enums.LanguageTypeEnum;
import olter.balls.database.importer.dto.BookImport;
import olter.balls.database.importer.dto.LanguageImport;
import olter.balls.database.languages.LanguageEntity;
import org.mapstruct.EnumMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImportMapper {
    BookEntity toBookEntity(BookImport book);

    @EnumMapping(nameTransformationStrategy = "case", configuration = "capital")
    LanguageTypeEnum typeToEnum(String type);

    LanguageEntity toLanguageEntity(LanguageImport language);
}
