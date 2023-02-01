package olter.balls.campaigns.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import olter.balls.common.NameResponse;
import olter.balls.connections.campaign_users.dto.CampaignUserListResponse;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CampaignListResponse extends NameResponse {
    private List<CampaignUserListResponse> relatedUsers;
}
