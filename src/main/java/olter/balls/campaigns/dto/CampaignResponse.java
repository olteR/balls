package olter.balls.campaigns.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import olter.balls.connections.campaign_users.dto.CampaignUserResponse;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CampaignResponse {
    private Integer id;
    private String name;
    private List<CampaignUserResponse> relatedUsers;
}
