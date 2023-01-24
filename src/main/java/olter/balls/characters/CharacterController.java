package olter.balls.characters;

import lombok.RequiredArgsConstructor;
import olter.balls.characters.dto.CharacterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("/characters/{userId}")
    public ResponseEntity<List<CharacterResponse>> getRelatedCampaigns(@PathVariable Integer userId) {
        return ResponseEntity.ok().body(characterService.getCharacters(userId));
    }
}
