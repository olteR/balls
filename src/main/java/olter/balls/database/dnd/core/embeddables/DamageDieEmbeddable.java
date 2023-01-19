package olter.balls.database.dnd.core.embeddables;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Embeddable
public class DamageDieEmbeddable {
    private Integer number;
    private Integer size;
}