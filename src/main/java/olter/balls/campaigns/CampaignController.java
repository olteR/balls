package olter.balls.campaigns;

import lombok.RequiredArgsConstructor;
import olter.balls.campaigns.dto.CampaignRequest;
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
    public ResponseEntity<List<CampaignResponse>> loginUser(@PathVariable Integer userId) {
        return campaignService.getRelatedCampaigns(userId);
    }
}
