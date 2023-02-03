package olter.balls.database.importer.dto.ancestry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@RequiredArgsConstructor
public class AncestryFeatureImport {
    private String name;
    private boolean unarmedAttack;
    private ArrayList<Object> entries;
}
