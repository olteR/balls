package olter.balls.users.security.dto;

import lombok.*;

@Data
public class LoginRequest {
    private String name;
    private String password;
}

