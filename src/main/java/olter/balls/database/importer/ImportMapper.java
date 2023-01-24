package olter.balls.database.importer;

import olter.balls.database.books.BookEntity;
import olter.balls.database.importer.dto.BookImport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImportMapper {
    BookEntity toBookEntity(BookImport book);
}
