package olter.balls.database.dnd.core.embeddables;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Embeddable
public class CurrencyEmbeddable {
    private Integer cp;
    private Integer sp;
    private Integer ep;
    private Integer gp;
    private Integer pp;
}
