package olter.balls.database.dnd.items;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "dnddb_weapons")
public class WeaponEntity extends ItemEntity {
    private Integer damageDies;
    private Integer damageDieSize;
    private boolean martial;
    private boolean ranged;
}
