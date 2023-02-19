package olter.balls.database.languages.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.exception.ResourceNotFoundException;
import olter.balls.database.languages.LanguageMapper;
import olter.balls.database.languages.dto.LanguageDetailsResponse;
import olter.balls.database.languages.dto.LanguageListResponse;
import olter.balls.database.languages.model.LanguageEntity;
import olter.balls.database.languages.model.LanguageRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LanguageService {
  private final LanguageRepository languageRepository;
  private final LanguageMapper languageMapper;

  public LanguageDetailsResponse getLanguage(Integer id) {
    Optional<LanguageEntity> entity = languageRepository.findById(id);
    if (entity.isPresent()) {
      return languageMapper.entityToDetailsResponse(entity.get());
    } else throw new ResourceNotFoundException("no language with such id");
  }

  public List<LanguageListResponse> getLanguages() {
    return languageRepository.findAll().stream().map(languageMapper::entityToListResponse).toList();
  }
}
