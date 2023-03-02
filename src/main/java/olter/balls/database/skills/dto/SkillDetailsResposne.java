package olter.balls.database.skills.dto;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.NameResponse;

@Getter
@Setter
@RequiredArgsConstructor
public class SkillDetailsResposne extends SkillListResponse {
  private String description;
  private List<NameResponse> trainedActions;
}
