package olter.balls.database.ancestries.ancestry.dto;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.NameResponse;
import olter.balls.database.core.embeddables.AbilityBoostEmbeddable;
import olter.balls.database.core.embeddables.FeatureEmbeddable;
import olter.balls.database.core.embeddables.SpeedEmbeddable;
import olter.balls.database.core.enums.CreatureSizeEnum;

@Getter
@Setter
@RequiredArgsConstructor
public class AncestryDetailsResponse extends AncestryListResponse {
  private Integer hp;
  private SpeedEmbeddable speed;
  private List<FeatureEmbeddable> description;
  private List<CreatureSizeEnum> sizes;
  private List<AbilityBoostEmbeddable> abilityBoosts;
  private List<NameResponse> knownLanguages;
  private Integer additionalLanguages;
  private List<NameResponse> traits;
}
