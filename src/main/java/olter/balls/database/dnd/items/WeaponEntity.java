package olter.balls.database.dnd.items;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.dnd.core.embeddables.DamageDieEmbeddable;
import olter.balls.database.dnd.races.RaceEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "dnddb_weapons")
public class WeaponEntity extends BaseItemEntity {
    @Embedded
    private DamageDieEmbeddable damage;
    private boolean martial;
    private boolean ranged;
    @ElementCollection
    @CollectionTable(name = "dnddb_weapon_properties", joinColumns = @JoinColumn(name = "source_id"))
    private List<WeaponPropertyEmbeddable> properties;

    @ManyToMany(mappedBy = "weaponProficiencies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RaceEntity> racesWithProficiency;
}
