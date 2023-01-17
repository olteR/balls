package olter.balls.rulesets.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RulesetResponse {
    private Integer id;
    private String name;
    private String shortName;
    private Integer coreDice;
}
