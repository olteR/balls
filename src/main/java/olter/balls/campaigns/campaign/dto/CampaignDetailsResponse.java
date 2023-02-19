package olter.balls.campaigns.campaign.dto;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.campaigns.hub.dto.ArticleListResponse;
import olter.balls.common.NameResponse;
import olter.balls.connections.campaign_users.dto.CampaignUserDetailsResponse;

@Getter
@Setter
@RequiredArgsConstructor
public class CampaignDetailsResponse extends NameResponse {
  private String description;
  private List<ArticleListResponse> articles;
  private List<CampaignUserDetailsResponse> relatedUsers;
}
