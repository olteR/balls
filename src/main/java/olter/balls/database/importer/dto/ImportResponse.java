package olter.balls.database.importer.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.NameResponse;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ImportResponse {
  List<NameResponse> imported;
  List<NameResponse> updated;
}
