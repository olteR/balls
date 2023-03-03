package olter.balls.database.sources.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import olter.balls.database.sources.dto.SourceListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/database")
@RequiredArgsConstructor
public class SourceEndpoint {
  private final SourceService sourceService;

  @GetMapping("/source/{id}")
  public ResponseEntity<SourceListResponse> getSource(@PathVariable Long id) {
    return ResponseEntity.ok().body(sourceService.getSource(id));
  }

  @GetMapping("/sources")
  public ResponseEntity<List<SourceListResponse>> getSources() {
    return ResponseEntity.ok().body(sourceService.getSources());
  }
}
