package olter.balls.characters.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.NameResponse;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CharacterResponse {
    private Integer id;
    private String name;
    private NameResponse ancestry;
    private List<NameResponse> campaigns;
    private NameResponse characterClass;
}
