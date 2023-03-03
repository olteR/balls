package olter.balls.database.importer.dto.action;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ActivityImport {
    private Long number;
    private String unit;
    private String entry;
}
