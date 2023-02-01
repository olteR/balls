package olter.balls.campaigns.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.campaigns.hub.dto.ArticleListResponse;
import olter.balls.common.NameResponse;
import olter.balls.connections.campaign_users.dto.CampaignUserDetailsResponse;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CampaignDetailsResponse extends NameResponse {
    private String description;
    private List<ArticleListResponse> articles;
    private List<CampaignUserDetailsResponse> relatedUsers;
}
