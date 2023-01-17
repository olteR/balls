package olter.balls.database.dnd.core.embeddables;

import jakarta.persistence.Embeddable;
import lombok.Data;
import olter.balls.database.dnd.core.enums.AbilityScoreEnum;

@Data
@Embeddable
public class AbilityScoreIncreaseEmbeddable {
    AbilityScoreEnum abilityScore;
    Integer amount;
}
