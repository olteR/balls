package olter.balls.users.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    Integer id;
    String name;
    String token;
}
