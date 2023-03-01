package olter.balls.database.core.embeddables;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.core.enums.ActivityUnitEnum;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Embeddable
public class ActivityEmbeddable {
  private Integer number;
  private ActivityUnitEnum units;
}
