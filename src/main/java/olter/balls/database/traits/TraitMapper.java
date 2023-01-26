package olter.balls.database.traits;

import olter.balls.database.traits.dto.TraitResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TraitMapper {
    TraitResponse entityToResponse(TraitEntity entity);
    List<TraitResponse> entityToResponseList(List<TraitEntity> entities);
}
