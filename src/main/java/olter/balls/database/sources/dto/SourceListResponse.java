package olter.balls.database.sources.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SourceListResponse {
  private Long id;
  private String name;
  private String shortName;
  private LocalDate published;
}
