package olter.balls.users;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import olter.balls.users.security.dto.LoginRequest;
import olter.balls.users.security.dto.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }

    @PostMapping("/users/refresh")
    public ResponseEntity<LoginResponse> refreshUser(@RequestBody String jwt) {
        return userService.refreshUser(jwt);
    }
}

