package olter.balls.database.books;

import jakarta.persistence.Column;
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
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String shortName;
    private LocalDate published;
}
