package olter.balls.database.dnd.backgrounds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.characters.CharacterEntity;
import olter.balls.database.dnd.core.SourcedEntity;
import olter.balls.database.dnd.items.ItemEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "dnddb_backgrounds")
public class BackgroundEntity extends SourcedEntity {
    private String name;

    @Column(columnDefinition="TEXT")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dnddb_background_starter_items",
            joinColumns = {@JoinColumn(name = "background_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    List<ItemEntity> startingItems;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "background")
    private List<CharacterEntity> characters;
}
