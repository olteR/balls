package olter.balls.database.core.embeddables;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.core.enums.AbilityScoreEnum;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Embeddable
public class AbilityBoostEmbeddable {
  @Enumerated(EnumType.STRING)
  private AbilityScoreEnum abilityScore;

  private boolean free;
  private boolean flaw;
}
