package olter.balls.characters.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.characters.CharacterMapper;
import olter.balls.characters.dto.CharacterListResponse;
import olter.balls.characters.model.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CharacterService {

  private final CharacterRepository characterRepository;
  private final CharacterMapper characterMapper;

  public List<CharacterListResponse> getCharacters(Integer userId) {
    log.info("Serving characters for user " + userId);
    return characterRepository.findAllByOwnerId(userId).stream()
        .map(characterMapper::entityToResponse)
        .toList();
  }
}
