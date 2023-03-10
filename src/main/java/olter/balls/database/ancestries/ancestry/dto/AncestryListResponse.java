package olter.balls.database.ancestries.ancestry.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AncestryListResponse {
  private Long id;
  private String name;
  private String rarity;
  private String source;
  private Long page;
}
