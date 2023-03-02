package olter.balls.database.skills;

import olter.balls.database.skills.dto.SkillDetailsResposne;
import olter.balls.database.skills.dto.SkillListResponse;
import olter.balls.database.skills.model.SkillEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillListResponse entityToListResponse(SkillEntity entity);
    SkillDetailsResposne entityToDetailsResponse(SkillEntity entity);
}
