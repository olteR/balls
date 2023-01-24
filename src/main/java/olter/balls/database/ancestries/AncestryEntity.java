package olter.balls.database.ancestries;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.characters.CharacterEntity;
import olter.balls.database.core.SourcedEntity;
import olter.balls.database.core.embeddables.SpeedEmbeddable;
import olter.balls.database.core.enums.AbilityChangeEnum;
import olter.balls.database.core.enums.CreatureSizeEnum;
import olter.balls.database.languages.LanguageEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "ancestries")
public class AncestryEntity extends SourcedEntity {
    @Column(unique = true)
    private String name;
    private Integer hp;

    @Embedded
    private SpeedEmbeddable speed;

    @ElementCollection
    @CollectionTable(name = "race_sizes", joinColumns = @JoinColumn(name = "race_id"))
    private List<CreatureSizeEnum> sizes;

    @ElementCollection
    @CollectionTable(name = "race_ability_boosts", joinColumns = @JoinColumn(name = "race_id"))
    private List<AbilityChangeEnum> abilityBoosts;

    @ElementCollection
    @CollectionTable(name = "race_ability_flaws", joinColumns = @JoinColumn(name = "race_id"))
    private List<AbilityChangeEnum> abilityFlaws;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ancestry")
    private List<CharacterEntity> characters;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "ancestry_known_languages",
            joinColumns = {@JoinColumn(name = "ancestry_id")},
            inverseJoinColumns = {@JoinColumn(name = "language_id")})
    private List<LanguageEntity> knownLanguages;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "ancestry_additional_languages",
            joinColumns = {@JoinColumn(name = "ancestry_id")},
            inverseJoinColumns = {@JoinColumn(name = "language_id")})
    private List<LanguageEntity> additionalLanguages;
}
