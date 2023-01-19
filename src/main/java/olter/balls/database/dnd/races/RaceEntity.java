package olter.balls.database.dnd.races;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import olter.balls.characters.CharacterEntity;
import olter.balls.database.dnd.core.SourcedEntity;
import olter.balls.database.dnd.core.embeddables.AbilityScoreIncreaseEmbeddable;
import olter.balls.database.dnd.core.embeddables.FeatureEmbeddable;
import olter.balls.database.dnd.core.enums.LanguageEnum;
import olter.balls.database.dnd.core.enums.SizeEnum;
import olter.balls.database.dnd.core.enums.SkillEnum;
import olter.balls.database.dnd.items.ArmorEntity;
import olter.balls.database.dnd.items.WeaponEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "dnddb_races")
public class RaceEntity extends SourcedEntity {
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

    @Enumerated(EnumType.STRING)
    private RaceTypeEnum type;

    @Enumerated(EnumType.STRING)
    private SizeEnum sizeType;

    @ElementCollection
    @CollectionTable(name = "dnddb_race_skill_proficiencies", joinColumns = @JoinColumn(name = "source_id"))
    private List<SkillEnum> skillProficiencies;

    @ElementCollection
    @CollectionTable(name = "dnddb_race_language_proficiencies", joinColumns = @JoinColumn(name = "source_id"))
    private List<LanguageEnum> languageProficiencies;

    @ElementCollection
    @CollectionTable(name = "dnddb_race_ability_score_increases", joinColumns = @JoinColumn(name = "source_id"))
    private List<AbilityScoreIncreaseEmbeddable> abilityScoreIncreases;

    @ElementCollection
    @CollectionTable(name = "dnddb_race_features", joinColumns = @JoinColumn(name = "owner_id"))
    private List<FeatureEmbeddable> features;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "race")
    private List<CharacterEntity> characters;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dnddb_race_weapon_proficiencies",
            joinColumns = {@JoinColumn(name = "race_id")},
            inverseJoinColumns = {@JoinColumn(name = "weapon_id")})
    private List<WeaponEntity> weaponProficiencies;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dnddb_race_armor_proficiencies",
            joinColumns = {@JoinColumn(name = "race_id")},
            inverseJoinColumns = {@JoinColumn(name = "armor_id")})
    private List<ArmorEntity> armorProficiencies;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dnddb_race_tool_proficiencies",
            joinColumns = {@JoinColumn(name = "race_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<ArmorEntity> toolProficiencies;
}
