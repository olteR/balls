package olter.balls.database.core.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
  private Long minCast;
  private Long maxCast;

  @Enumerated(EnumType.STRING)
  private ActivityUnitEnum minCastUnits;

  @Enumerated(EnumType.STRING)
  private ActivityUnitEnum maxCastUnits;

  @Column(name = "specialActivity")
  private String special;
}
