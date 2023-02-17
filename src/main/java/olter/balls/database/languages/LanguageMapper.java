package olter.balls.database.languages;

import java.util.List;
import olter.balls.common.NameResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
	NameResponse entityToNameResponse(LanguageEntity entity);

	List<NameResponse> entityToNameResponseList(List<LanguageEntity> entities);
}
