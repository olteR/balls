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
@Table(name = "dnddb_items")
public class ItemEntity extends BaseItemEntity {
}
