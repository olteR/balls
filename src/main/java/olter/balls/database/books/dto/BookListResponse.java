package olter.balls.database.books.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BookListResponse {
  private Long id;
  private String name;
  private String shortName;
  private LocalDate published;
}
