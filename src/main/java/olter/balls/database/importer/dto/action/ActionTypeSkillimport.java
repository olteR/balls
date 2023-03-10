package olter.balls.database.importer.dto.action;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ActionTypeSkillimport {
  private List<String> untrained;
  private List<String> trained;
}
