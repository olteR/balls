package olter.balls.connections.campaign_users.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.characters.dto.CharacterCampaignResponse;
import olter.balls.connections.campaign_users.CampaignUserConnectionEnum;
import olter.balls.users.dto.UserResponse;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class CampaignUserDetailsResponse {
    private UserResponse user;
    private Set<CharacterCampaignResponse> characters;
    private CampaignUserConnectionEnum role;
}
