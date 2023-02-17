package olter.balls.database.ancestries;

import java.util.List;
import olter.balls.common.NameResponse;
import olter.balls.database.ancestries.dto.AncestryDetailsResponse;
import olter.balls.database.ancestries.dto.AncestryListResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AncestryMapper {
	AncestryDetailsResponse entityToDetailsResponse(AncestryEntity entity);

	AncestryListResponse entityToListResponse(AncestryEntity entity);

	List<AncestryListResponse> entityToListResponseList(List<AncestryEntity> entities);

	NameResponse entityToNameResponse(AncestryEntity entity);

	List<NameResponse> entityToNameResponseList(List<AncestryEntity> entities);
}