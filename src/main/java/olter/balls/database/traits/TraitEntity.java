package olter.balls.database.traits;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.core.SourcedEntity;

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
}
