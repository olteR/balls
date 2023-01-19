package olter.balls.database.dnd.core.embeddables;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import olter.balls.database.dnd.core.enums.AbilityScoreEnum;

@Getter
@Setter
@RequiredArgsConstructor
@Embeddable
public class AbilityScoreIncreaseEmbeddable {
    @Enumerated(EnumType.STRING)
    AbilityScoreEnum abilityScore;
    Integer amount;
}
