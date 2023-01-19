package olter.balls.campaigns.dto;

import lombok.Data;
import olter.balls.characters.dto.CharacterResponse;
import olter.balls.connections.campaign_users.dto.CampaignUserResponse;
import olter.balls.rulesets.dto.RulesetResponse;
import olter.balls.users.dto.UserResponse;

import java.util.List;

@Data
public class CampaignResponse {
    private Integer id;
    private String name;
    private RulesetResponse ruleset;
    private List<CampaignUserResponse> relatedUsers;
}
