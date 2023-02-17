package olter.balls.characters;

import java.util.List;
import lombok.RequiredArgsConstructor;
import olter.balls.characters.dto.CharacterListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CharacterController {

	private final CharacterService characterService;

	@GetMapping("/characters/{userId}")
	public ResponseEntity<List<CharacterListResponse>> getRelatedCampaigns(
			@PathVariable Integer userId) {
		return ResponseEntity.ok().body(characterService.getCharacters(userId));
	}
}
