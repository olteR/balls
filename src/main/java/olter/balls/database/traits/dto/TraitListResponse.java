package olter.balls.database.traits.dto;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TraitListResponse {
  private Integer id;
  private String name;
  List<String> categories;
  private String source;
  private Integer page;
}
