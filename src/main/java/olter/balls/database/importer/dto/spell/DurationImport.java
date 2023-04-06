package olter.balls.database.importer.dto.spell;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.importer.dto.ValueWithUnitImport;

@Getter
@Setter
@RequiredArgsConstructor
public class DurationImport extends ValueWithUnitImport {
    private boolean dismiss;
    private boolean sustained;
}
