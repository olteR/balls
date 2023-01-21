package olter.balls.database.dnd.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.BaseEntity;
import olter.balls.database.dnd.items.MundaneItemEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "dnddb_item_choices")
public class ItemChoiceEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classWithChoice;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dnddb_class_item_choice",
            joinColumns = {@JoinColumn(name = "choice_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<MundaneItemEntity> itemChoices;
}
