package olter.balls.database.importer.dto.ancestry;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@RequiredArgsConstructor
public class AncestrySummaryImport {
    private String text;
    private ArrayList<String> images;
}
