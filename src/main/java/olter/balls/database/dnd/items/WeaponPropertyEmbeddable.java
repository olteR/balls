package olter.balls.database.dnd.items;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.dnd.core.embeddables.DamageDieEmbeddable;

@Getter
@Setter
@RequiredArgsConstructor
@Embeddable
public class WeaponPropertyEmbeddable {
    private WeaponPropertyTypeEnum type;
    private DamageDieEmbeddable damage;
    private Integer normalRange;
    private Integer maxRange;
}
