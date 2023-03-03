package olter.balls.database.sources.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.NameResponse;
import olter.balls.common.exception.ResourceNotFoundException;
import olter.balls.database.sources.SourceMapper;
import olter.balls.database.sources.dto.SourceListResponse;
import olter.balls.database.sources.model.SourceEntity;
import olter.balls.database.sources.model.SourceRepository;
import olter.balls.database.importer.dto.SourceImport;
import olter.balls.database.importer.dto.ImportResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SourceService {
  private final SourceRepository sourceRepository;
  private final SourceMapper sourceMapper;

  public SourceListResponse getSource(Long id) {
    Optional<SourceEntity> entity = sourceRepository.findById(id);
    if (entity.isPresent()) {
      return sourceMapper.entityToListResponse(entity.get());
    } else throw new ResourceNotFoundException("no source with such id");
  }

  public List<SourceListResponse> getSources() {
    return sourceRepository.findAll().stream().map(sourceMapper::entityToListResponse).toList();
  }

  public ImportResponse processImports(SourceImport[] imports) {
    List<NameResponse> importedSources = new ArrayList<>();
    List<NameResponse> updatedSources = new ArrayList<>();
    for (SourceImport source : imports) {
      if (source.isVanilla()) {
        Optional<SourceEntity> oEntity = sourceRepository.findByShortName(source.getShortName());
        log.info(
                oEntity.isPresent()
                        ? "Updating " + source.getName() + "..."
                        : "Importing " + source.getName() + "...");
        SourceEntity entity = oEntity.orElseGet(SourceEntity::new);
        sourceMapper.map(source, entity);
        sourceRepository.save(entity);
        if (oEntity.isPresent()) updatedSources.add(sourceMapper.entityToNameResponse(entity));
        else importedSources.add(sourceMapper.entityToNameResponse(entity));
      }
    }
    log.info("Imported " + importedSources.size() + " books");
    log.info("Updated " + updatedSources.size() + " books");
    return new ImportResponse(importedSources, updatedSources);
  }
}
