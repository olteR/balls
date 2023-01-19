package olter.balls.database.dnd.backgrounds;

import jakarta.persistence.*;
import lombok.Data;
import olter.balls.characters.CharacterEntity;
import olter.balls.common.BaseEntity;
import olter.balls.database.dnd.races.RaceEntity;
import olter.balls.database.dnd.source_books.SourceBookEntity;

import java.util.List;

@Entity
@Data
@Table(name = "dnddb_backgrounds")
public class BackgroundEntity extends BaseEntity {
    private String name;

    @Column(columnDefinition="TEXT")
    String description;

    //TODO: EQUIPMENT

    @ManyToOne
    @JoinColumn(name="source_book_id", nullable=false)
    SourceBookEntity sourceBook;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "background")
    List<CharacterEntity> characters;
}
