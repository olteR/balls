package olter.balls.database.traits.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.core.enums.TraitCategoryEnum;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class TraitResponse {
    private Integer id;
    private String source;
    private Integer page;
    private String name;
    private List<TraitCategoryEnum> traits;
    private String description;
}
