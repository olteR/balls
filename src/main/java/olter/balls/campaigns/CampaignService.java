package olter.balls.campaigns;

import lombok.RequiredArgsConstructor;
import olter.balls.campaigns.dto.CampaignResponse;
import olter.balls.connections.campaign_users.CampaignUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignService {

    private final CampaignUserRepository campaignUserRepository;
    private final CampaignMapper campaignMapper;

    public ResponseEntity<List<CampaignResponse>> getRelatedCampaigns(Integer userId) {
        return ResponseEntity.ok().body(campaignUserRepository.findAllByUserId(userId).stream().map(cu -> campaignMapper.entityToResponse(cu.getCampaign())).toList());
    }
}
