package olter.balls.campaigns.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.connections.campaign_users.dto.CampaignUserResponse;
import olter.balls.rulesets.dto.RulesetResponse;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CampaignResponse {
    private Integer id;
    private String name;
    private RulesetResponse ruleset;
    private List<CampaignUserResponse> relatedUsers;
}
