package olter.balls.database.core.embeddables;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.core.enums.FrequencyUnitEnum;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Embeddable
public class FrequencyEmbeddable {
    private Long count;
    private Long interval;
    private FrequencyUnitEnum timespan;
    private String special;
}
