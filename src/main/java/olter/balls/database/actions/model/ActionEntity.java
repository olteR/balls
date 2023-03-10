package olter.balls.database.actions.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import olter.balls.database.ancestries.heritage.model.HeritageEntity;
import olter.balls.database.core.SourcedEntity;
import olter.balls.database.core.embeddables.ActivityEmbeddable;
import olter.balls.database.core.embeddables.FrequencyEmbeddable;
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

  private boolean basic;

  @Embedded private ActivityEmbeddable activity;
  @Embedded private FrequencyEmbeddable frequency;

  @Column(columnDefinition = "TEXT")
  private String prerequisites;

  @Column(columnDefinition = "TEXT")
  private String requirements;

  @Column(name = "actionTrigger", columnDefinition = "TEXT")
  private String trigger;

  @Column(columnDefinition = "TEXT")
  private String cost;

  @Column(columnDefinition = "TEXT")
  private String description;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "related_ancestry", referencedColumnName = "id")
  private AncestryEntity relatedAncestry;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "related_heritage", referencedColumnName = "id")
  private HeritageEntity relatedHeritage;

  @ManyToMany(mappedBy = "trainedActions", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<SkillEntity> relatedTrainedSkills;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
      name = "action_traits",
      joinColumns = {@JoinColumn(name = "action_id")},
      inverseJoinColumns = {@JoinColumn(name = "trait_id")})
  private List<TraitEntity> traits;
}
