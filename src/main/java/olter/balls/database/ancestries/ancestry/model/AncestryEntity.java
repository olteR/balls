package olter.balls.database.ancestries.ancestry.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.characters.model.CharacterEntity;
import olter.balls.database.actions.model.ActionEntity;
import olter.balls.database.ancestries.heritage.model.HeritageEntity;
import olter.balls.database.core.SourcedEntity;
import olter.balls.database.core.embeddables.AbilityBoostEmbeddable;
import olter.balls.database.core.embeddables.FeatureEmbeddable;
import olter.balls.database.core.embeddables.SpeedEmbeddable;
import olter.balls.database.core.enums.CreatureSizeEnum;
import olter.balls.database.languages.model.LanguageEntity;
import olter.balls.database.traits.model.TraitEntity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "ancestries")
public class AncestryEntity extends SourcedEntity {
  @Column(unique = true)
  private String name;

  private Long hp;
  private Long additionalLanguages;

  @Enumerated(EnumType.STRING)
  private AncestryRarityEnum rarity;

  @Embedded private SpeedEmbeddable speed;

  @ElementCollection
  @CollectionTable(name = "ancestry_features", joinColumns = @JoinColumn(name = "ancestry_id"))
  private List<FeatureEmbeddable> description;

  @ElementCollection
  @CollectionTable(name = "ancestry_sizes", joinColumns = @JoinColumn(name = "ancestry_id"))
  @Enumerated(EnumType.STRING)
  private List<CreatureSizeEnum> sizes;

  @ElementCollection
  @CollectionTable(
      name = "ancestry_ability_boosts",
      joinColumns = @JoinColumn(name = "ancestry_id"))
  private List<AbilityBoostEmbeddable> abilityBoosts;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ancestry")
  private List<CharacterEntity> characters;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ancestry")
  private List<HeritageEntity> heritages;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "related_action", referencedColumnName = "id")
  private ActionEntity relatedAction;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
      name = "ancestry_languages",
      joinColumns = {@JoinColumn(name = "ancestry_id")},
      inverseJoinColumns = {@JoinColumn(name = "language_id")})
  private List<LanguageEntity> knownLanguages;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
      name = "ancestry_traits",
      joinColumns = {@JoinColumn(name = "ancestry_id")},
      inverseJoinColumns = {@JoinColumn(name = "trait_id")})
  private List<TraitEntity> traits;
}
