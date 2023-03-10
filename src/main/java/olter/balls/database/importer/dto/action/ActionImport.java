package olter.balls.database.importer.dto.action;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionImport {
  private String name;
  private ActivityImport activity;
  private FrequencyImport frequency;
  private String source;
  private Long page;
  private List<String> traits;
  private String prerequisites;
  private String requirements;
  private String trigger;
  private List<Object> entries;
  private List<String> special;
  private ActionTypeImport actionType;
  private List<Object> info;
  private String cost;
  private String add_hash;
}
