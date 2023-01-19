package olter.balls.database.dnd.classes;

import jakarta.persistence.*;
import lombok.Data;
import olter.balls.characters.CharacterEntity;
import olter.balls.common.BaseEntity;
import olter.balls.database.dnd.races.RaceEntity;

import java.util.List;

@Entity
@Data
@Table(name = "dnddb_classes")
public class ClassEntity extends BaseEntity {
    private String name;

    //TODO: everything...

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "characterClass")
    List<CharacterEntity> characters;
}
