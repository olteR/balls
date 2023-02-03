package olter.balls.database.books;

import olter.balls.common.NameResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    NameResponse entityToResponse(BookEntity entity);
    List<NameResponse> entityToNameResponseList(List<BookEntity> entities);
}
