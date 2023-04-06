package olter.balls.database.importer.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ValueWithUnitImport {
  private Long number;
  private String unit;
  private String entry;
}
