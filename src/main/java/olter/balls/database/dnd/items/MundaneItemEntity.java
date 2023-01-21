package olter.balls.database.dnd.items;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.dnd.classes.ClassEntity;
import olter.balls.database.dnd.classes.ItemChoiceEntity;
import olter.balls.database.dnd.races.RaceEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "dnddb_items")
public class MundaneItemEntity extends ItemEntity {
    @ManyToMany(mappedBy = "weaponProficiencies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RaceEntity> racesWithProficiency;

    @ManyToMany(mappedBy = "weaponProficiencies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ClassEntity> classesWithProficiency;

    @ManyToMany(mappedBy = "itemChoices", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ItemChoiceEntity> classesWithStartingItemChoice;
}
