package olter.balls.rulesets.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
public class RulesetResponse {
    private Integer id;
    private String name;
    private String shortName;
    private Integer coreDice;
}
