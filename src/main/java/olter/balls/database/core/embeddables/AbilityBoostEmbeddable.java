package olter.balls.database.core.embeddables;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.core.enums.AbilityScoreEnum;

@Getter
@Setter
@RequiredArgsConstructor
@Embeddable
public class AbilityBoostEmbeddable {
    private AbilityScoreEnum abilityScore;
    private boolean free;
    private boolean flaw;
}
