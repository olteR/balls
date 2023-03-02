package olter.balls.database.importer.dto.ancestry;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AncestrySpeedImport {
  private Long walk;
  private Long swim;
}
