package olter.balls.database.ancestries.ancestry.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import olter.balls.database.ancestries.ancestry.dto.AncestryDetailsResponse;
import olter.balls.database.ancestries.ancestry.dto.AncestryListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/database")
@RequiredArgsConstructor
public class AncestryEndpoint {

  private final AncestryService ancestryService;

  @GetMapping("/ancestry/{id}")
  public ResponseEntity<AncestryDetailsResponse> getAncestry(@PathVariable Integer id) {
    return ResponseEntity.ok().body(ancestryService.getAncestry(id));
  }

  @GetMapping("/ancestries")
  public ResponseEntity<List<AncestryListResponse>> getAncestries() {
    return ResponseEntity.ok().body(ancestryService.getAncestries());
  }
}
