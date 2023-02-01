package olter.balls.campaigns;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.campaigns.hub.ArticleEntity;
import olter.balls.common.BaseEntity;
import olter.balls.connections.campaign_users.CampaignUserEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "campaigns")
public class CampaignEntity extends BaseEntity {
    private String name;

    @Column(columnDefinition="TEXT")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "campaign")
    private List<ArticleEntity> articles;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "campaign")
    private List<CampaignUserEntity> relatedUsers;
}
