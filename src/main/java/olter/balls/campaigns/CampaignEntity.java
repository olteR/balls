package olter.balls.campaigns;

import jakarta.persistence.*;
import lombok.Data;
import olter.balls.common.BaseEntity;
import olter.balls.connections.campaign_users.CampaignUserEntity;
import olter.balls.rulesets.RulesetEntity;

import java.util.List;

@Entity
@Data
@Table(name = "campaigns")
public class CampaignEntity extends BaseEntity {
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "campaign")
    private List<CampaignUserEntity> relatedUsers;

    @ManyToOne
    @JoinColumn(name = "ruleset_id")
    private RulesetEntity ruleset;
}
