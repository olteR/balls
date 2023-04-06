package olter.balls.database.spells.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.core.SourcedEntity;
import olter.balls.database.core.embeddables.ActivityEmbeddable;
import olter.balls.database.core.enums.SpellComponentEnum;
import olter.balls.database.core.enums.SpellTraditionEnum;
import olter.balls.database.traits.model.TraitEntity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "spells")
public class SpellEntity extends SourcedEntity {
  private String name;
  private Long level;

  private boolean focus;

  @Column(name = "spellTrigger", columnDefinition = "TEXT")
  private String trigger;

  @Column(columnDefinition = "TEXT")
  private String targets;

  @Column(columnDefinition = "TEXT")
  private String requirements;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Embedded private ActivityEmbeddable activity;

  @ElementCollection
  @CollectionTable(name = "spell_components", joinColumns = @JoinColumn(name = "spell_id"))
  @Enumerated(EnumType.STRING)
  private List<SpellComponentEnum> components;

  @ElementCollection
  @CollectionTable(name = "spell_traditions", joinColumns = @JoinColumn(name = "spell_id"))
  @Enumerated(EnumType.STRING)
  private List<SpellTraditionEnum> traditions;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
      name = "spell_traits",
      joinColumns = {@JoinColumn(name = "spell_id")},
      inverseJoinColumns = {@JoinColumn(name = "trait_id")})
  private List<TraitEntity> traits;
}
