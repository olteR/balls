package olter.balls.database.importer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import olter.balls.common.NameResponse;
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
  public ResponseEntity<List<NameResponse>> importAncestries() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importAncestries());
  }

  @GetMapping("/import/books")
  public ResponseEntity<List<NameResponse>> importBooks() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importBooks());
  }

  @GetMapping("/import/languages")
  public ResponseEntity<List<NameResponse>> importLanguages() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importLanguages());
  }

  @GetMapping("/import/traits")
  public ResponseEntity<List<NameResponse>> importTraits() throws JsonProcessingException {
    return ResponseEntity.ok().body(importerService.importTraits());
  }
}
