package olter.balls.database.spells.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.NameResponse;
import olter.balls.database.importer.dto.ImportResponse;
import olter.balls.database.importer.dto.spell.SpellImport;
import olter.balls.database.spells.SpellMapper;
import olter.balls.database.spells.model.SpellEntity;
import olter.balls.database.spells.model.SpellRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SpellService {
  private final SpellRepository spellRepository;
  private final SpellMapper spellMapper;

  public ImportResponse processImports(List<SpellImport> imports) {
    List<NameResponse> importedSpells = new ArrayList<>();
    List<NameResponse> updatedSpells = new ArrayList<>();
    for (SpellImport spellImport : imports) {
      Optional<SpellEntity> oEntity = spellRepository.findByName(spellImport.getName());
      log.info(
          oEntity.isPresent()
              ? "Updating " + spellImport.getName() + "..."
              : "Importing " + spellImport.getName() + "...");
      SpellEntity entity = oEntity.orElseGet(SpellEntity::new);
      spellMapper.map(spellImport, entity);

      spellRepository.save(entity);

      if (oEntity.isPresent()) updatedSpells.add(spellMapper.entityToNameResponse(entity));
      else importedSpells.add(spellMapper.entityToNameResponse(entity));
    }

    log.info("Imported " + importedSpells.size() + " spells");
    log.info("Updated " + importedSpells.size() + " spells");
    return new ImportResponse(importedSpells, updatedSpells);
  }
}
