package olter.balls.database.ancestries.ancestry;

import olter.balls.common.NameResponse;
import olter.balls.database.ancestries.ancestry.dto.AncestryDetailsResponse;
import olter.balls.database.ancestries.ancestry.dto.AncestryListResponse;
import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AncestryMapper {
  AncestryDetailsResponse entityToDetailsResponse(AncestryEntity entity);

  AncestryListResponse entityToListResponse(AncestryEntity entity);

  NameResponse entityToNameResponse(AncestryEntity entity);
}
