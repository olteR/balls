package olter.balls.characters.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.NameResponse;

@Getter
@Setter
@RequiredArgsConstructor
public class CharacterCampaignResponse extends NameResponse {
  private Integer level;
  private NameResponse ancestry;
  private NameResponse characterClass;
}
