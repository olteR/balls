package olter.balls.characters.dto;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.NameResponse;

@Getter
@Setter
@RequiredArgsConstructor
public class CharacterListResponse extends NameResponse {
  private NameResponse ancestry;
  private List<NameResponse> campaigns;
  private NameResponse characterClass;
}
