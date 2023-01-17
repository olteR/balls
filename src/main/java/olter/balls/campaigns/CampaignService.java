package olter.balls.campaigns;

import lombok.RequiredArgsConstructor;
import olter.balls.campaigns.dto.CampaignResponse;
import olter.balls.characters.CharacterEntity;
import olter.balls.characters.CharacterMapper;
import olter.balls.characters.CharacterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CampaignService {

    private final CampaignRepository campaignRepository;
    private final CampaignMapper campaignMapper;
    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    public ResponseEntity<List<CampaignResponse>> getRelatedCampaigns(Integer userId) {
        Set<CampaignResponse> response = new HashSet<>(campaignMapper.entityToResponseList(campaignRepository.findAllByGameMasterId(userId)));
        response.addAll(campaignMapper.entityToResponseList(characterRepository.findCampaignsByOwnerId(userId)));
        response.forEach(c -> {
            c.setCharacters(characterMapper.entityToResponseList(characterRepository.findAllCharactersByCampaignId(c.getId())));
        });
        return ResponseEntity.ok().body(response.stream().toList());
    }
}
