package olter.balls.database.books;

import olter.balls.common.NameResponse;
import olter.balls.database.books.dto.BookListResponse;
import olter.balls.database.books.model.BookEntity;
import olter.balls.database.importer.dto.BookImport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
  NameResponse entityToNameResponse(BookEntity entity);

  BookListResponse entityToListResponse(BookEntity entity);

  @Mapping(target = "id", ignore = true)
  BookEntity map(BookImport source, @MappingTarget BookEntity target);
}
