package olter.balls.database.importer.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import olter.balls.common.NameResponse;

@Getter
@Setter
@AllArgsConstructor
public class ImportResponse {
  List<NameResponse> imported;
  List<NameResponse> updated;

  public ImportResponse() {
    this.imported = new ArrayList<>();
    this.updated = new ArrayList<>();
  }
}
