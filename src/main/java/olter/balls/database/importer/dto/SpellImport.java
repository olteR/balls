package olter.balls.database.importer.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class SpellImport {
    private String name;
    private String source;
    private Long page;
    private Long level;
    private List<String> traits;
    private List<String> traditions;
    private ActivityImport cast;
    private List<String> components;
}
