package olter.balls.database.dnd.core.embeddables;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import olter.balls.database.dnd.core.enums.AbilityScoreEnum;

@Data
@Embeddable
public class AbilityScoreIncreaseEmbeddable {
    @Enumerated(EnumType.STRING)
    AbilityScoreEnum abilityScore;
    Integer amount;
}
