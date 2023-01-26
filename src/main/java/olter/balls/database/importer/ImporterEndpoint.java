package olter.balls.database.importer;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import olter.balls.database.books.dto.BookResponse;
import olter.balls.database.languages.dto.LanguageResponse;
import olter.balls.database.traits.dto.TraitResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ImporterEndpoint {

    private final ImporterService importerService;

    @GetMapping("/import/books")
    public ResponseEntity<List<BookResponse>> importBooks() throws JsonProcessingException {
        return ResponseEntity.ok().body(importerService.importBooks());
    }

    @GetMapping("/import/languages")
    public ResponseEntity<List<LanguageResponse>> importLanguages() throws JsonProcessingException {
        return ResponseEntity.ok().body(importerService.importLanguages());
    }

    @GetMapping("/import/traits")
    public ResponseEntity<List<TraitResponse>> importTraits() throws JsonProcessingException {
        return ResponseEntity.ok().body(importerService.importTraits());
    }
}
