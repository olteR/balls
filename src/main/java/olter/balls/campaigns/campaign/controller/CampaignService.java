package olter.balls.campaigns.campaign.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.campaigns.campaign.CampaignMapper;
import olter.balls.campaigns.campaign.dto.CampaignDetailsResponse;
import olter.balls.campaigns.campaign.dto.CampaignListResponse;
import olter.balls.campaigns.campaign.model.CampaignEntity;
import olter.balls.campaigns.campaign.model.CampaignRepository;
import olter.balls.common.exception.ResourceNotFoundException;
import olter.balls.connections.campaign_users.model.CampaignUserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CampaignService {

  private final CampaignRepository campaignRepository;
  private final CampaignUserRepository campaignUserRepository;
  private final CampaignMapper campaignMapper;

  public List<CampaignListResponse> getRelatedCampaigns(Long userId) {
    log.info("Serving campaigns for user " + userId);
    return campaignUserRepository.findAllByUserId(userId).stream()
        .map(cu -> campaignMapper.entityToListResponse(cu.getCampaign()))
        .toList();
  }

  public CampaignDetailsResponse getCampaignDetails(Long id) throws ResourceNotFoundException {
    log.info("Serving campaign " + id);
    Optional<CampaignEntity> campaign = campaignRepository.findById(id);
    if (campaign.isPresent()) {
      return campaignMapper.entityToDetailsResponse(campaign.get());
    } else {
      throw new ResourceNotFoundException(CampaignEntity.class.getName(), id);
    }
  }
}
