package olter.balls.campaigns.dto;

import lombok.Data;

@Data
public class CampaignRequest {
    private Integer userId;
    private boolean gmCampaigns;
    private boolean playerCampaigns;
}
