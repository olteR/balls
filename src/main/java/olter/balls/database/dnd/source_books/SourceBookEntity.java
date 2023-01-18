package olter.balls.database.dnd.source_books;

import jakarta.persistence.*;
import lombok.Data;
import olter.balls.database.dnd.races.RaceEntity;

import java.util.List;

@Entity
@Data
@Table(name = "dnddb_source_books")
public class SourceBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balls_generator")
    @SequenceGenerator(name = "balls_generator", sequenceName = "balls_id_seq", initialValue = 1000000, allocationSize = 1)
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sourceBook")
    List<RaceEntity> races;
}
