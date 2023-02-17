package olter.balls.characters;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.characters.dto.CharacterListResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CharacterService {

  private final CharacterRepository characterRepository;
  private final CharacterMapper characterMapper;

  List<CharacterListResponse> getCharacters(Integer userId) {
    log.info("Serving characters for user " + userId);
    return characterMapper.entityToResponseList(characterRepository.findAllByOwnerId(userId));
  }
}
