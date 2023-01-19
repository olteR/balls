package olter.balls.users.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    Integer id;
    String name;
    String token;
}
