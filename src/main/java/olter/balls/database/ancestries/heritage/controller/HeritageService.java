package olter.balls.database.ancestries.heritage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.NameResponse;
import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import olter.balls.database.ancestries.heritage.HeritageMapper;
import olter.balls.database.ancestries.heritage.model.HeritageEntity;
import olter.balls.database.ancestries.heritage.model.HeritageRepository;
import olter.balls.database.importer.dto.ImportResponse;
import olter.balls.database.importer.dto.ancestry.HeritageImport;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HeritageService {

  private final HeritageRepository heritageRepository;
  private final HeritageMapper heritageMapper;

  public ImportResponse processImports(List<HeritageImport> imports, AncestryEntity ancestry) {
    List<NameResponse> importedHeritages = new ArrayList<>();
    List<NameResponse> updatedHeritages = new ArrayList<>();
    for (HeritageImport heritageImport : imports) {
      Optional<HeritageEntity> oEntity = heritageRepository.findByName(heritageImport.getName());
      log.info(
          oEntity.isPresent()
              ? "Updating " + heritageImport.getName() + "..."
              : "Importing " + heritageImport.getName() + "...");
      HeritageEntity entity = oEntity.orElseGet(HeritageEntity::new);
      heritageMapper.map(heritageImport, entity);
      entity.setDescription(
          "<p>"
              .concat(
                  heritageImport.getEntries().stream()
                      .filter(e -> e.getClass() == String.class)
                      .map(Object::toString)
                      .collect(Collectors.joining("<p></p>"))
                      .concat("</p>")));
      entity.setAncestry(ancestry);
      heritageRepository.save(entity);
      if (oEntity.isPresent()) updatedHeritages.add(heritageMapper.entityToNameResponse(entity));
      else importedHeritages.add(heritageMapper.entityToNameResponse(entity));
    }
    return new ImportResponse(importedHeritages, updatedHeritages);
  }
}
