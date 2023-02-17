package olter.balls.database.core.embeddables;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Embeddable
public class SpeedEmbeddable {
  private Integer walking;
  private Integer swimming;
}
