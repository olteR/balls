package olter.balls.database.importer.dto.action;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class FrequencyImport {
  private Long freq;
  private Long interval;
  private String unit;
  private String special;
}
