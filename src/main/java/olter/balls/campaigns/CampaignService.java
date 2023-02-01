package olter.balls.campaigns;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.campaigns.dto.CampaignDetailsResponse;
import olter.balls.campaigns.dto.CampaignListResponse;
import olter.balls.common.exception.ResourceNotFoundException;
import olter.balls.connections.campaign_users.CampaignUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CampaignService {

    private final CampaignRepository campaignRepository;
    private final CampaignUserRepository campaignUserRepository;
    private final CampaignMapper campaignMapper;

    public List<CampaignListResponse> getRelatedCampaigns(Integer userId) {
        log.info("Serving campaigns for user " + userId);
        return campaignUserRepository.findAllByUserId(userId).stream().map(cu -> campaignMapper.entityToListResponse(cu.getCampaign())).toList();
    }

    public CampaignDetailsResponse getCampaignDetails(Integer id) throws ResourceNotFoundException {
        log.info("Serving campaign " + id);
        Optional<CampaignEntity> campaign = campaignRepository.findById(id);
        if (campaign.isPresent()) {
            return campaignMapper.entityToDetailsResponse(campaign.get());
        }
        else {
            throw new ResourceNotFoundException("No such campaign");
        }
    }
}
