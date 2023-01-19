package olter.balls.database.dnd.races;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import olter.balls.characters.CharacterEntity;
import olter.balls.common.BaseEntity;
import olter.balls.database.dnd.core.embeddables.AbilityScoreIncreaseEmbeddable;
import olter.balls.database.dnd.core.embeddables.FeatureEmbeddable;
import olter.balls.database.dnd.core.enums.SizeEnum;
import olter.balls.database.dnd.source_books.SourceBookEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "dnddb_races")
public class RaceEntity extends BaseEntity {
    private String name;
    @Column(columnDefinition="TEXT")
    private String description;
    @Column(columnDefinition="TEXT")
    private String age;
    @Column(columnDefinition="TEXT")
    private String alignment;
    @Column(columnDefinition="TEXT")
    private String size;
    private Integer speed;

    @ManyToOne
    @JoinColumn(name="source_book_id", nullable=false)
    private SourceBookEntity sourceBook;

    @Enumerated(EnumType.STRING)
    private RaceTypeEnum type;

    @Enumerated(EnumType.STRING)
    private SizeEnum sizeType;

    @ElementCollection
    @CollectionTable(name = "ability_score_increases", joinColumns = @JoinColumn(name = "source_id"))
    private List<AbilityScoreIncreaseEmbeddable> abilityScoreIncreases;

    @ElementCollection
    @CollectionTable(name = "features", joinColumns = @JoinColumn(name = "owner_id"))
    private List<FeatureEmbeddable> features;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "race")
    private List<CharacterEntity> characters;
}
