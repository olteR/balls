package olter.balls.campaigns.dto;

import lombok.Data;
import olter.balls.rulesets.dto.RulesetResponse;
import olter.balls.users.dto.UserResponse;

@Data
public class CampaignResponse {
    private Integer id;
    private String name;
    private String shortName;
    private RulesetResponse ruleset;
    private UserResponse gameMaster;
}
