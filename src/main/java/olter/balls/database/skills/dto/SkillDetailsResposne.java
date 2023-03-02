package olter.balls.database.skills.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.NameResponse;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class SkillDetailsResposne extends SkillListResponse {
    private String description;
    private List<NameResponse> trainedActions;
}
