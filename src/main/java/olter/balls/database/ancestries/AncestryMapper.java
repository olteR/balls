package olter.balls.database.ancestries;

import olter.balls.database.ancestries.dto.AncestryResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AncestryMapper {
    AncestryResponse entityToResponse(AncestryEntity entity);
    List<AncestryResponse> entityToResponseList(List<AncestryEntity> entities);
}
