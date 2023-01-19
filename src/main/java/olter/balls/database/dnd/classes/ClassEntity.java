package olter.balls.database.dnd.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.characters.CharacterEntity;
import olter.balls.common.BaseEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "dnddb_classes")
public class ClassEntity extends BaseEntity {
    private String name;

    //TODO: everything...

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "characterClass")
    List<CharacterEntity> characters;
}
