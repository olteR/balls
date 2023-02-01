package olter.balls.database.importer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeritageImport {
    private String name;
    private String shortName;
    private String source;
    private int page;
    private ArrayList<Object> entries;
}
