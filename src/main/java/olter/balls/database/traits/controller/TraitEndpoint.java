package olter.balls.database.traits.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import olter.balls.database.traits.dto.TraitListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/database")
@RequiredArgsConstructor
public class TraitEndpoint {
  private final TraitService traitService;

  @GetMapping("/trait/{id}")
  public ResponseEntity<TraitListResponse> getTrait(@PathVariable Integer id) {
    return ResponseEntity.ok().body(traitService.getTrait(id));
  }

  @GetMapping("/traits")
  public ResponseEntity<List<TraitListResponse>> getTraits() {
    return ResponseEntity.ok().body(traitService.getTraits());
  }
}
