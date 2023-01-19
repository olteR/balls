package olter.balls.connections.campaign_users.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.characters.dto.CharacterResponse;
import olter.balls.connections.campaign_users.CampaignUserConnectionEnum;
import olter.balls.users.dto.UserResponse;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class CampaignUserResponse {
    UserResponse user;
    Set<CharacterResponse> characters;
    CampaignUserConnectionEnum role;
}
