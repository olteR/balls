package olter.balls.database.ancestries;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.core.SourcedEntity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "eritages")
public class HeritageEntity extends SourcedEntity {
  private String name;
  private String shortName;
}
