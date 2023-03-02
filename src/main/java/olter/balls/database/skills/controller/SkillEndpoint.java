package olter.balls.database.skills.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import olter.balls.database.skills.dto.SkillDetailsResposne;
import olter.balls.database.skills.dto.SkillListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/database")
@RequiredArgsConstructor
public class SkillEndpoint {
  private final SkillService skillService;

  @GetMapping("/skill/{id}")
  public ResponseEntity<SkillDetailsResposne> getAncestry(@PathVariable Long id) {
    return ResponseEntity.ok().body(skillService.getSkill(id));
  }

  @GetMapping("/skills")
  public ResponseEntity<List<SkillListResponse>> getAncestries() {
    return ResponseEntity.ok().body(skillService.getSkills());
  }
}
