package olter.balls.characters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.characters.dto.CharacterResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    List<CharacterResponse> getCharacters(Integer userId) {
        log.info("Serving characters for user " + userId);
        return characterMapper.entityToResponseList(characterRepository.findAllByOwnerId(userId));
    }
}
