package olter.balls.database.languages.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import olter.balls.database.languages.dto.LanguageDetailsResponse;
import olter.balls.database.languages.dto.LanguageListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/database")
@RequiredArgsConstructor
public class LanguageEndpoint {

  private final LanguageService languageService;

  @GetMapping("/language/{id}")
  public ResponseEntity<LanguageDetailsResponse> getAncestry(@PathVariable Long id) {
    return ResponseEntity.ok().body(languageService.getLanguage(id));
  }

  @GetMapping("/languages")
  public ResponseEntity<List<LanguageListResponse>> getAncestries() {
    return ResponseEntity.ok().body(languageService.getLanguages());
  }
}
