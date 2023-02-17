package olter.balls.database.ancestries.dto;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.NameResponse;
import olter.balls.database.ancestries.AncestryRarityEnum;
import olter.balls.database.core.embeddables.AbilityBoostEmbeddable;
import olter.balls.database.core.embeddables.FeatureEmbeddable;
import olter.balls.database.core.embeddables.SpeedEmbeddable;
import olter.balls.database.core.enums.CreatureSizeEnum;

@Getter
@Setter
@RequiredArgsConstructor
public class AncestryDetailsResponse {
  private Integer id;
  private String source;
  private Integer page;
  private String name;
  private Integer hp;
  private AncestryRarityEnum rarity;

  private SpeedEmbeddable speed;

  private List<FeatureEmbeddable> features;
  private List<CreatureSizeEnum> sizes;
  private List<AbilityBoostEmbeddable> abilityBoosts;
  private List<NameResponse> knownLanguages;
  private Integer additionalLanguages;
}
