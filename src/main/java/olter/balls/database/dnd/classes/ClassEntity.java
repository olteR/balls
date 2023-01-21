package olter.balls.database.dnd.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.characters.CharacterEntity;
import olter.balls.common.BaseEntity;
import olter.balls.connections.character_classes.CharacterClassEntity;
import olter.balls.database.dnd.core.SourcedEntity;
import olter.balls.database.dnd.core.embeddables.FeatureEmbeddable;
import olter.balls.database.dnd.core.enums.AbilityScoreEnum;
import olter.balls.database.dnd.core.enums.SkillEnum;
import olter.balls.database.dnd.items.ArmorEntity;
import olter.balls.database.dnd.items.MundaneItemEntity;
import olter.balls.database.dnd.items.WeaponEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "dnddb_classes")
public class ClassEntity extends SourcedEntity {
    private String name;
    private Integer hitDice;
    private Integer proficiencyCount;

    @Column(columnDefinition="TEXT")
    private String description;

    @ElementCollection
    @CollectionTable(name = "dnddb_class_features", joinColumns = @JoinColumn(name = "source_id"))
    private List<FeatureEmbeddable> features;

    @ElementCollection
    @CollectionTable(name = "dnddb_class_saving_throws", joinColumns = @JoinColumn(name = "race_id"))
    private List<AbilityScoreEnum> savingThrows;

    @ElementCollection
    @CollectionTable(name = "dnddb_class_skill_proficiencies", joinColumns = @JoinColumn(name = "source_id"))
    private List<SkillEnum> choosableSkillProficiencies;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "classWithChoice")
    private List<ItemChoiceEntity> choosableStartingItems;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "characterClass")
    private List<CharacterClassEntity> characters;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dnddb_class_weapon_proficiencies",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "weapon_id")})
    private List<WeaponEntity> weaponProficiencies;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dnddb_class_armor_proficiencies",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "armor_id")})
    private List<ArmorEntity> armorProficiencies;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dnddb_class_tool_proficiencies",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<MundaneItemEntity> toolProficiencies;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dnddb_class_starting_items",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<MundaneItemEntity> startingItems;
}
