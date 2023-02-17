package olter.balls.database.importer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguageImport {
  private String name;
  private String type;
  private String source;
  private Integer page;
  private ArrayList<String> typicalSpeakers;
  private ArrayList<Object> entries;
}
