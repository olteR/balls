package olter.balls.database.traits;

import java.util.List;
import olter.balls.common.NameResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TraitMapper {
	NameResponse entityToNameResponse(TraitEntity entity);

	List<NameResponse> entityToNameResponseList(List<TraitEntity> entities);
}
