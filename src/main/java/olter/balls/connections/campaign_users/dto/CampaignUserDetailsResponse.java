package olter.balls.connections.campaign_users.dto;

import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.characters.dto.CharacterCampaignResponse;
import olter.balls.connections.campaign_users.model.CampaignUserConnectionEnum;
import olter.balls.users.dto.UserResponse;

@Getter
@Setter
@RequiredArgsConstructor
public class CampaignUserDetailsResponse {
  private UserResponse user;
  private Set<CharacterCampaignResponse> characters;
  private CampaignUserConnectionEnum role;
}
