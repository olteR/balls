package olter.balls.database.importer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import olter.balls.database.importer.dto.ImportResponse;
import olter.balls.database.importer.dto.ancestry.AncestryImportResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ImporterEndpoint {

  private final ImporterService importerService;

  @GetMapping("/import/abilities")
  public ResponseEntity<ImportResponse> importAbilities() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importActions());
  }

  @GetMapping("/import/actions")
  public ResponseEntity<ImportResponse> importActions() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importActions());
  }

  @GetMapping("/import/ancestries")
  public ResponseEntity<AncestryImportResponse> importAncestries() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importAncestries());
  }

  @GetMapping("/import/backgrounds")
  public ResponseEntity<ImportResponse> importBackgrounds() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importBackgrounds());
  }

  @GetMapping("/import/classes")
  public ResponseEntity<ImportResponse> importClasses() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importClasses());
  }

  @GetMapping("/import/conditions")
  public ResponseEntity<ImportResponse> importConditions() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importConditions());
  }

  @GetMapping("/import/feats")
  public ResponseEntity<ImportResponse> importFeats() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importFeats());
  }

  @GetMapping("/import/items")
  public ResponseEntity<ImportResponse> importItems() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importItems());
  }

  @GetMapping("/import/languages")
  public ResponseEntity<ImportResponse> importLanguages() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importLanguages());
  }

  @GetMapping("/import/sources")
  public ResponseEntity<ImportResponse> importSources() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importSources());
  }

  @GetMapping("/import/spells")
  public ResponseEntity<ImportResponse> importSpells() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importSpells());
  }

  @GetMapping("/import/traits")
  public ResponseEntity<ImportResponse> importTraits() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importTraits());
  }
}
