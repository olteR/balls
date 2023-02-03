package olter.balls.database.languages.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.languages.LanguageTypeEnum;

@Getter
@Setter
@RequiredArgsConstructor
public class LanguageResponse {
    private Integer id;
    private String name;
    private LanguageTypeEnum type;
    private String source;
    private Integer page;
}
