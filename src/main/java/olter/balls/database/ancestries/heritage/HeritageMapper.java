package olter.balls.database.ancestries.heritage;

import olter.balls.common.NameResponse;
import olter.balls.database.ancestries.heritage.model.HeritageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HeritageMapper {
  NameResponse entityToNameResponse(HeritageEntity entity);
}
