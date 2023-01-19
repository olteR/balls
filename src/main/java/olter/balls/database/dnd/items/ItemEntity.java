package olter.balls.database.dnd.items;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.BaseEntity;
import olter.balls.database.dnd.core.embeddables.CurrencyEmbeddable;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@MappedSuperclass
@Table(name = "dnddb_items")
public class ItemEntity extends BaseEntity {
    private String name;

    @Embedded
    private CurrencyEmbeddable cost;

    private Integer weight;
}
