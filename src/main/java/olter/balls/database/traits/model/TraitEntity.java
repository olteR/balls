package olter.balls.database.traits.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.actions.model.ActionEntity;
import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import olter.balls.database.core.SourcedEntity;
import olter.balls.database.spells.model.SpellEntity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "traits")
public class TraitEntity extends SourcedEntity {
  private String name;

  @ElementCollection
  @CollectionTable(name = "trait_categories", joinColumns = @JoinColumn(name = "trait_id"))
  @Enumerated(EnumType.STRING)
  private List<TraitCategoryEnum> categories;

  @Column(columnDefinition = "TEXT")
  private String description;

  @ManyToMany(mappedBy = "traits", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<ActionEntity> relatedActions;

  @ManyToMany(mappedBy = "traits", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<AncestryEntity> relatedAncestries;

  @ManyToMany(mappedBy = "traits", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<SpellEntity> relatedSpells;
}
