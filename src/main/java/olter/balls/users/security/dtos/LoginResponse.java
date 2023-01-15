package olter.balls.users.security.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    Integer id;
    String name;
    String token;
}
