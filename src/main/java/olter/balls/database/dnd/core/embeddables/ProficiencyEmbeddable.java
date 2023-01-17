package olter.balls.database.dnd.core.embeddables;

import jakarta.persistence.Embeddable;
import lombok.Data;
import olter.balls.database.dnd.core.enums.ProficiencyTypeEnum;

import java.util.List;

@Data
@Embeddable
public class ProficiencyEmbeddable {
    ProficiencyTypeEnum type;
    List<Integer> proficiencies;
}
