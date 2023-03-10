package olter.balls.database.importer.dto.action;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ActionTypeImport {
  private boolean basic;

  @JsonProperty("class")
  private List<String> characterClass;

  private List<String> subclass;
  private List<String> archetype;
  private List<String> ancestry;
  private List<String> heritage;
  private List<String> versatileHeritage;

  @JsonProperty("variantrule")
  private List<String> variantRule;

  private ActionTypeSkillimport skill;
  private boolean item;
}
