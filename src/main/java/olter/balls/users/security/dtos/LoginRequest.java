package olter.balls.users.security.dtos;

import lombok.*;

@Data
public class LoginRequest {
    private String name;
    private String password;
}

