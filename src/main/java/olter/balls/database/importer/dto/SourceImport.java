package olter.balls.database.importer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceImport {
  private String name;

  @JsonProperty("source")
  private String shortName;

  @JsonProperty("date")
  private String published;
  private boolean vanilla;
}
