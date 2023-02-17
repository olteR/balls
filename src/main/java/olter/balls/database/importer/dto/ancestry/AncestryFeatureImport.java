package olter.balls.database.importer.dto.ancestry;

import java.util.ArrayList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AncestryFeatureImport {
	private String name;
	private boolean unarmedAttack;
	private ArrayList<Object> entries;
}
