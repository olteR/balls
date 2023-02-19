package olter.balls.campaigns.campaign.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.campaigns.hub.model.ArticleEntity;
import olter.balls.common.BaseEntity;
import olter.balls.connections.campaign_users.model.CampaignUserEntity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "campaigns")
public class CampaignEntity extends BaseEntity {
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "campaign")
  private List<ArticleEntity> articles;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "campaign")
  private List<CampaignUserEntity> relatedUsers;
}
