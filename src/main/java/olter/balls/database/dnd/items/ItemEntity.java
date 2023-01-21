package olter.balls.database.dnd.items;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.dnd.core.SourcedEntity;
import olter.balls.database.dnd.core.embeddables.CurrencyEmbeddable;

@Getter
@Setter
@RequiredArgsConstructor
@MappedSuperclass
public class ItemEntity extends SourcedEntity {
    private String name;

    @Column(columnDefinition="TEXT")
    private String description;

    @Embedded
    private CurrencyEmbeddable cost;

    private Integer weight;
}
