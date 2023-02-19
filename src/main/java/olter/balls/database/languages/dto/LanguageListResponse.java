package olter.balls.database.languages.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.languages.model.LanguageTypeEnum;

@Getter
@Setter
@RequiredArgsConstructor
public class LanguageListResponse {
  private Integer id;
  private String source;
  private Integer page;
  private String name;
  private LanguageTypeEnum type;
}
