package olter.balls.database.traits;

import olter.balls.common.NameResponse;
import olter.balls.database.traits.dto.TraitListResponse;
import olter.balls.database.traits.model.TraitEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TraitMapper {
  NameResponse entityToNameResponse(TraitEntity entity);

  TraitListResponse entityToListResponse(TraitEntity entity);
}
