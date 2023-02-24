package olter.balls.database.importer.dto.ancestry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeritageImport {
  private String name;
  private String shortName;
  private String source;
  private Integer page;
  private List<Object> entries;
}
