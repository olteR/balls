package olter.balls.database.importer.dto.ancestry;

import java.util.ArrayList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AncestrySummaryImport {
	private String text;
	private ArrayList<String> images;
}
