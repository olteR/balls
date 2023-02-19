package olter.balls.database.languages.dto;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.NameResponse;

@Getter
@Setter
@RequiredArgsConstructor
public class LanguageDetailsResponse extends LanguageListResponse {
  private String description;
  private List<NameResponse> typicalSpeakers;
  List<NameResponse> ancestriesKnowing;
}
