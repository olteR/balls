package olter.balls.connections.campaign_users.dto;

import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.NameResponse;
import olter.balls.connections.campaign_users.CampaignUserConnectionEnum;
import olter.balls.users.dto.UserResponse;

@Getter
@Setter
@RequiredArgsConstructor
public class CampaignUserListResponse {
	private UserResponse user;
	private Set<NameResponse> characters;
	private CampaignUserConnectionEnum role;
}
