package olter.balls.database.books;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.BaseEntity;

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
