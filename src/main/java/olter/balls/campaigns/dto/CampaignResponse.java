package olter.balls.campaigns.dto;

import lombok.Data;
import olter.balls.characters.dto.CharacterResponse;
import olter.balls.rulesets.dto.RulesetResponse;
import olter.balls.users.dto.UserResponse;

import java.util.List;

@Data
public class CampaignResponse {
    private Integer id;
    private String name;
    private RulesetResponse ruleset;
    private UserResponse gameMaster;
    private List<CharacterResponse> characters;
}
