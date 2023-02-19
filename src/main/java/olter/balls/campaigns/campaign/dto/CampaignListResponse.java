package olter.balls.campaigns.campaign.dto;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.NameResponse;
import olter.balls.connections.campaign_users.dto.CampaignUserListResponse;

@Getter
@Setter
@RequiredArgsConstructor
public class CampaignListResponse extends NameResponse {
  private List<CampaignUserListResponse> relatedUsers;
}
