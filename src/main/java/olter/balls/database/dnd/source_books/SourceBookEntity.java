package olter.balls.database.dnd.source_books;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import olter.balls.common.BaseEntity;
import olter.balls.database.dnd.races.RaceEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "dnddb_source_books")
public class SourceBookEntity extends BaseEntity {
    private String name;
}
