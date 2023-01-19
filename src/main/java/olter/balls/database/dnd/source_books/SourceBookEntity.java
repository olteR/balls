package olter.balls.database.dnd.source_books;

import jakarta.persistence.*;
import lombok.Data;
import olter.balls.common.BaseEntity;
import olter.balls.database.dnd.races.RaceEntity;

import java.util.List;

@Entity
@Data
@Table(name = "dnddb_source_books")
public class SourceBookEntity extends BaseEntity {
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sourceBook")
    List<RaceEntity> races;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sourceBook")
    List<RaceEntity> backgrounds;
}
