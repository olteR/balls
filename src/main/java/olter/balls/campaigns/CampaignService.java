package olter.balls.campaigns;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.campaigns.dto.CampaignResponse;
import olter.balls.connections.campaign_users.CampaignUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CampaignService {

    private final CampaignUserRepository campaignUserRepository;
    private final CampaignMapper campaignMapper;

    public List<CampaignResponse> getRelatedCampaigns(Integer userId) {
        log.info("Serving campaigns for user " + userId);
        return campaignUserRepository.findAllByUserId(userId).stream().map(cu -> campaignMapper.entityToResponse(cu.getCampaign())).toList();
    }
}
