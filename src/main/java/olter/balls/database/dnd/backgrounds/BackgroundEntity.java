package olter.balls.database.dnd.backgrounds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.characters.CharacterEntity;
import olter.balls.database.dnd.core.SourcedEntity;

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

    //TODO: EQUIPMENT

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "background")
    private List<CharacterEntity> characters;
}
