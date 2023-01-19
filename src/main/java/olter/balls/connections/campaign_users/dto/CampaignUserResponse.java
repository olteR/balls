package olter.balls.connections.campaign_users.dto;

import lombok.Data;
import olter.balls.characters.dto.CharacterResponse;
import olter.balls.connections.campaign_users.CampaignUserConnectionEnum;
import olter.balls.users.dto.UserResponse;
import java.util.Set;

@Data
public class CampaignUserResponse {
    UserResponse user;
    Set<CharacterResponse> characters;
    CampaignUserConnectionEnum role;
}
