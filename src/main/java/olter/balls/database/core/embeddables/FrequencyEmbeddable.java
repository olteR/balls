package olter.balls.database.core.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
  private Long frequency;

  @Column(name = "timespanCount")
  private Long interval;

  @Enumerated(EnumType.STRING)
  private FrequencyUnitEnum timespan;

  @Column(name = "specialFrequency")
  private String special;
}
