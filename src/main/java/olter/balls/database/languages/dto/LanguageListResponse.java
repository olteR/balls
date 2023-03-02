package olter.balls.database.languages.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.languages.model.LanguageTypeEnum;

@Getter
@Setter
@RequiredArgsConstructor
public class LanguageListResponse {
  private Long id;
  private String source;
  private Long page;
  private String name;
  private LanguageTypeEnum type;
}
