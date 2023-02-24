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

  @GetMapping("/import/ancestries")
  public ResponseEntity<AncestryImportResponse> importAncestries() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importAncestries());
  }

  @GetMapping("/import/books")
  public ResponseEntity<ImportResponse> importBooks() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importBooks());
  }

  @GetMapping("/import/languages")
  public ResponseEntity<ImportResponse> importLanguages() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importLanguages());
  }

  @GetMapping("/import/traits")
  public ResponseEntity<ImportResponse> importTraits() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importTraits());
  }
}
