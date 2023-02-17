package olter.balls.users.security.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class LoginRequest {
	private String name;
	private String password;
}
