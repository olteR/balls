package olter.balls.database.ancestries;

import lombok.RequiredArgsConstructor;
import olter.balls.database.ancestries.dto.AncestryListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/database")
@RequiredArgsConstructor
public class AncestryController {

    private final AncestryService ancestryService;

    @GetMapping("/ancestries")
    public ResponseEntity<List<AncestryListResponse>> getAncestries() {
        return ResponseEntity.ok().body(ancestryService.getAncestries());
    }
}
