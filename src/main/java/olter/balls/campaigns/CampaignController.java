package olter.balls.campaigns;

import java.util.List;
import lombok.RequiredArgsConstructor;
import olter.balls.campaigns.dto.CampaignDetailsResponse;
import olter.balls.campaigns.dto.CampaignListResponse;
import olter.balls.common.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CampaignController {
  private final CampaignService campaignService;

  @GetMapping("/campaign/{id}")
  public ResponseEntity<CampaignDetailsResponse> getCampaignDetails(@PathVariable Integer id)
      throws ResourceNotFoundException {
    return ResponseEntity.ok().body(campaignService.getCampaignDetails(id));
  }

  @GetMapping("/campaigns/{userId}")
  public ResponseEntity<List<CampaignListResponse>> getRelatedCampaigns(
      @PathVariable Integer userId) {
    return ResponseEntity.ok().body(campaignService.getRelatedCampaigns(userId));
  }
}
