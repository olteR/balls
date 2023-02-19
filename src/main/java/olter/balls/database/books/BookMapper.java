package olter.balls.database.books;

import olter.balls.common.NameResponse;
import olter.balls.database.books.model.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
  NameResponse entityToResponse(BookEntity entity);
}
