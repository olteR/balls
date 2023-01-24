package olter.balls.database.books;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.BaseEntity;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "books")
public class BookEntity extends BaseEntity {
    private String name;
    private String shortName;
    private LocalDate published;
}
