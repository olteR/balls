package olter.balls.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
public class UserResponse {
    private Integer id;
    private String name;
    private String displayName;
}
