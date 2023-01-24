package olter.balls.characters.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.NameResponse;
import olter.balls.connections.character_classes.dto.CharacterClassResponse;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CharacterResponse {
    private Integer id;
    private String name;
    private NameResponse race;
    private List<NameResponse> campaigns;
    private List<CharacterClassResponse> classes;
}
