package olter.balls.characters.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.users.dto.UserResponse;

@Getter
@Setter
@RequiredArgsConstructor
public class CharacterResponse {
    private Integer id;
    private String name;
}
