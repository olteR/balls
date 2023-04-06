package olter.balls.database.importer.dto.spell;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class SavingThrowImport {
    private List<String> type;
    private boolean basic;
}
