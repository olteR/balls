package olter.balls.database.importer.dto.spell;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AreaImport {
  private List<String> types;
  private String entry;
}
