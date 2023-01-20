package olter.balls.campaigns;

import lombok.RequiredArgsConstructor;
import olter.balls.campaigns.dto.CampaignResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService campaignService;

    @GetMapping("/campaigns/{userId}")
    public ResponseEntity<List<CampaignResponse>> getRelatedCampaigns(@PathVariable Integer userId) {
        return ResponseEntity.ok().body(campaignService.getRelatedCampaigns(userId));
    }
}
