package olter.balls.characters;

import lombok.RequiredArgsConstructor;
import olter.balls.characters.dto.CharacterResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    List<CharacterResponse> getCharacters(Integer userId) {
        return characterMapper.entityToResponseList(characterRepository.findAllByOwnerId(userId));
    }
}
