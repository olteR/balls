package olter.balls.database.importer.dto.ancestry;

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
public class AncestryImportResponse {
  List<NameResponse> importedAncestries;
  List<NameResponse> updatedAncestries;
  List<NameResponse> importedHeritages;
  List<NameResponse> updatedHeritages;
}
