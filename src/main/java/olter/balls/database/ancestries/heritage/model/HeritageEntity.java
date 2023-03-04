package olter.balls.database.ancestries.heritage.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.actions.model.ActionEntity;
import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import olter.balls.database.core.SourcedEntity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "heritages")
public class HeritageEntity extends SourcedEntity {
  @Column(unique = true)
  private String name;

  private String shortName;

  @Column(columnDefinition = "TEXT")
  private String description;

  @OneToOne(mappedBy = "relatedHeritage")
  private ActionEntity relatedAction;

  @ManyToOne
  @JoinColumn(name = "ancestry_id")
  private AncestryEntity ancestry;
}
