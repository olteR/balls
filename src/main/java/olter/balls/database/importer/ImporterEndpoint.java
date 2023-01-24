package olter.balls.database.importer;

import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Integer> importBooks() {
        return ResponseEntity.ok().body(importerService.importBooks());
    }
}
