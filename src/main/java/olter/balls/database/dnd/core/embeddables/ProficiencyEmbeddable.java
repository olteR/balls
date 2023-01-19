package olter.balls.database.dnd.core.embeddables;

import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import olter.balls.database.dnd.core.enums.ProficiencyTypeEnum;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Embeddable
@MappedSuperclass
public class ProficiencyEmbeddable {
    ProficiencyTypeEnum type;
}
