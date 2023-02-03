package olter.balls.database.traits;

import olter.balls.common.NameResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TraitMapper {
    NameResponse entityToNameResponse(TraitEntity entity);
    List<NameResponse> entityToNameResponseList(List<TraitEntity> entities);
}
