package olter.balls.database.books.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class BookResponse {
    private Integer id;
    private String name;
    private String shortName;
    private LocalDate published;
}
