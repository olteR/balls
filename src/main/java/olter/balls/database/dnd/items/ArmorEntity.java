package olter.balls.database.dnd.items;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.dnd.classes.ClassEntity;
import olter.balls.database.dnd.races.RaceEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "dnddb_armors")
public class ArmorEntity extends ItemEntity {
    private Integer armorClass;
    @Enumerated(EnumType.STRING)
    private ArmorTypeEnum type;
    private boolean stealthDisadvantage;
    private Integer strengthRequirement;

    @ManyToMany(mappedBy = "armorProficiencies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RaceEntity> racesWithProficiency;

    @ManyToMany(mappedBy = "armorProficiencies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ClassEntity> classesWithProficiency;
}
