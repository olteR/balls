package olter.balls.database.books;

import olter.balls.database.books.dto.BookResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponse entityToResponse(BookEntity entity);
    List<BookResponse> entityToResponseList(List<BookEntity> entities);
}
