package olter.balls.database.languages.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.NameResponse;
import olter.balls.common.exception.ResourceNotFoundException;
import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import olter.balls.database.ancestries.ancestry.model.AncestryRepository;
import olter.balls.database.importer.dto.ImportResponse;
import olter.balls.database.importer.dto.LanguageImport;
import olter.balls.database.languages.LanguageMapper;
import olter.balls.database.languages.dto.LanguageDetailsResponse;
import olter.balls.database.languages.dto.LanguageListResponse;
import olter.balls.database.languages.model.LanguageEntity;
import olter.balls.database.languages.model.LanguageRepository;
import olter.balls.database.languages.model.SpeakerEmbeddable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class LanguageService {
  private final LanguageRepository languageRepository;
  private final LanguageMapper languageMapper;

  private final AncestryRepository ancestryRepository;

  public LanguageDetailsResponse getLanguage(Long id) {
    Optional<LanguageEntity> entity = languageRepository.findById(id);
    if (entity.isPresent()) {
      return languageMapper.entityToDetailsResponse(entity.get());
    } else throw new ResourceNotFoundException("no language with such id");
  }

  public List<LanguageListResponse> getLanguages() {
    return languageRepository.findAll().stream().map(languageMapper::entityToListResponse).toList();
  }

  public ImportResponse processImports(LanguageImport[] imports) {
    List<NameResponse> importedLanguages = new ArrayList<>();
    List<NameResponse> updatedLanguages = new ArrayList<>();
    for (LanguageImport lang : imports) {
      Optional<LanguageEntity> oEntity = languageRepository.findByName(lang.getName());
      log.info(
          oEntity.isPresent()
              ? "Updating " + lang.getName() + "..."
              : "Importing " + lang.getName() + "...");
      LanguageEntity entity = oEntity.orElseGet(LanguageEntity::new);
      languageMapper.map(lang, entity);
      if (lang.getEntries() != null) {
        entity.setDescription(
            "<p>"
                .concat(
                    String.join(
                        "</p><p>",
                        lang.getEntries().stream()
                            .filter(l -> l.getClass() == String.class)
                            .map(Object::toString)
                            .toList()))
                .concat("</p>"));
      }
      if (lang.getTypicalSpeakers() != null) {
        List<SpeakerEmbeddable> speakers = new ArrayList<>();
        lang.getTypicalSpeakers()
            .forEach(
                ts -> {
                  SpeakerEmbeddable speaker = new SpeakerEmbeddable();
                  if (ts.startsWith("{@ancestry")) {
                    String name = ts.substring(ts.indexOf(' ') + 1, ts.indexOf('|'));
                    Optional<AncestryEntity> ancestry = ancestryRepository.findByName(name);
                    ancestry.ifPresent(ancestryEntity -> speaker.setId(ancestryEntity.getId()));
                    speaker.setName(
                        StringUtils.countOccurrencesOf(ts, "|") == 2
                            ? ts.substring(ts.lastIndexOf('|') + 1, ts.indexOf('}'))
                            : name);
                  } else {
                    speaker.setName(ts);
                  }
                  speakers.add(speaker);
                });
        entity.setTypicalSpeakers(speakers);
      }
      languageRepository.save(entity);
      if (oEntity.isPresent()) updatedLanguages.add(languageMapper.entityToNameResponse(entity));
      else importedLanguages.add(languageMapper.entityToNameResponse(entity));
    }
    log.info("Imported " + importedLanguages.size() + " languages");
    log.info("Updated " + updatedLanguages.size() + " languages");
    return new ImportResponse(importedLanguages, updatedLanguages);
  }
}
