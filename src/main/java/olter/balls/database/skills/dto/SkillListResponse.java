package olter.balls.database.skills.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SkillListResponse {
  private Long id;
  private String name;
  private String source;
  private Long page;
  private String keyAbility;
}
