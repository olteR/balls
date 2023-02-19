package olter.balls.characters.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.BaseEntity;
import olter.balls.connections.campaign_users.model.CampaignUserEntity;
import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import olter.balls.users.UserEntity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "characters")
public class CharacterEntity extends BaseEntity {
  private String name;
  private Integer level;

  @ManyToOne
  @JoinColumn(name = "owner_id", nullable = false)
  private UserEntity owner;

  //    @ManyToOne
  //    @JoinColumn(name = "background_id")
  //    private BackgroundEntity background;

  //    @ManyToOne
  //    @JoinColumn(name = "class_id")
  //    private ClassEntity characterClass;

  @ManyToOne
  @JoinColumn(name = "ancestry_id")
  private AncestryEntity ancestry;

  @ManyToMany(mappedBy = "characters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<CampaignUserEntity> campaigns;
}
