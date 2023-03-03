package olter.balls.database.actions.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.core.SourcedEntity;
import olter.balls.database.core.embeddables.ActivityEmbeddable;
import olter.balls.database.skills.model.SkillEntity;
import olter.balls.database.traits.model.TraitEntity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "actions")
public class ActionEntity extends SourcedEntity {
  @Column(unique = true)
  private String name;

  @Embedded private ActivityEmbeddable activity;

  @ManyToMany(mappedBy = "trainedActions", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<SkillEntity> relatedTrainedSkills;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
      name = "action_traits",
      joinColumns = {@JoinColumn(name = "action_id")},
      inverseJoinColumns = {@JoinColumn(name = "trait_id")})
  private List<TraitEntity> traits;
}
