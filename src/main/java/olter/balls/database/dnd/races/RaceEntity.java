package olter.balls.database.dnd.races;

import jakarta.persistence.*;
import lombok.Data;
import olter.balls.characters.CharacterEntity;
import olter.balls.common.BaseEntity;
import olter.balls.database.dnd.core.embeddables.AbilityScoreIncreaseEmbeddable;
import olter.balls.database.dnd.core.embeddables.FeatureEmbeddable;
import olter.balls.database.dnd.core.enums.RaceTypeEnum;
import olter.balls.database.dnd.core.enums.SizeEnum;
import olter.balls.database.dnd.source_books.SourceBookEntity;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Data
@Table(name = "dnddb_races")
public class RaceEntity extends BaseEntity {
    String name;
    @Column(columnDefinition="TEXT")
    String description;
    @Column(columnDefinition="TEXT")
    String age;
    @Column(columnDefinition="TEXT")
    String alignment;
    @Column(columnDefinition="TEXT")
    String size;
    Integer speed;

    @ManyToOne
    @JoinColumn(name="source_book_id", nullable=false)
    SourceBookEntity sourceBook;

    @Enumerated(EnumType.STRING)
    RaceTypeEnum type;

    @Enumerated(EnumType.STRING)
    SizeEnum sizeType;

    @ElementCollection
    @CollectionTable(name = "ability_score_increases", joinColumns = @JoinColumn(name = "source_id"))
    List<AbilityScoreIncreaseEmbeddable> abilityScoreIncreases;

    @ElementCollection
    @CollectionTable(name = "features", joinColumns = @JoinColumn(name = "owner_id"))
    List<FeatureEmbeddable> features;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "race")
    List<CharacterEntity> characters;
}
