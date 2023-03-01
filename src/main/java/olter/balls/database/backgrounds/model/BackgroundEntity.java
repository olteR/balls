package olter.balls.database.backgrounds.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.core.SourcedEntity;
import olter.balls.database.core.embeddables.AbilityBoostEmbeddable;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "backgrounds")
public class BackgroundEntity extends SourcedEntity {
  @Column(unique = true)
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  @ElementCollection
  @CollectionTable(
      name = "background_ability_boosts",
      joinColumns = @JoinColumn(name = "background_id"))
  private List<AbilityBoostEmbeddable> abilityBoosts;
}
