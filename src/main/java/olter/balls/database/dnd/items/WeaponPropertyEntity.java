package olter.balls.database.dnd.items;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.BaseEntity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "dnddb_weapon_properties")
public class WeaponPropertyEntity extends BaseEntity {
    private String name;
    @Column(columnDefinition="TEXT")
    private String description;
}
