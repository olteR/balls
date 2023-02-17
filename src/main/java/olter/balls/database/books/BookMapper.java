package olter.balls.database.books;

import java.util.List;
import olter.balls.common.NameResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
  NameResponse entityToResponse(BookEntity entity);

  List<NameResponse> entityToNameResponseList(List<BookEntity> entities);
}
