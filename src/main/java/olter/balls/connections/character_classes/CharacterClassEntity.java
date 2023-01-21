package olter.balls.connections.character_classes;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.characters.CharacterEntity;
import olter.balls.common.BaseEntity;
import olter.balls.database.dnd.classes.ClassEntity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "character_class")
public class CharacterClassEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private CharacterEntity character;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClassEntity characterClass;

    private Integer level;
}
