package olter.balls.database.dnd.classes;

import jakarta.persistence.*;
import lombok.Data;
import olter.balls.characters.CharacterEntity;
import olter.balls.database.dnd.races.RaceEntity;

import java.util.List;

@Entity
@Data
@Table(name = "dnddb_classes")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balls_generator")
    @SequenceGenerator(name = "balls_generator", sequenceName = "balls_id_seq", initialValue = 1000000, allocationSize = 1)
    private Integer id;
    private String name;

    //TODO: everything...

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "characterClass")
    List<CharacterEntity> characters;
}
