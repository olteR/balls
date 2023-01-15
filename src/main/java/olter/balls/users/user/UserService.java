package olter.balls.users.user;

import lombok.RequiredArgsConstructor;
import olter.balls.users.security.JwtHandler;
import olter.balls.users.security.dtos.LoginRequest;
import olter.balls.users.security.dtos.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtHandler jwtHandler;

    public ResponseEntity<LoginResponse> loginUser(LoginRequest loginRequest) {
        UserEntity user = userRepository.findByName(loginRequest.getName()).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found with this name"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
        }
        return ResponseEntity.ok().body(new LoginResponse(user.getId(), user.getName(), jwtHandler.generateJwt(user.getName(), new HashMap<>())));
    }

    public ResponseEntity<LoginResponse> refreshUser(String jwt) {
        try {
            UserEntity user = userRepository.findByName(jwtHandler.getUsernameFromToken(jwt)).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found with this name"));
            return ResponseEntity.ok().body(new LoginResponse(user.getId(), user.getName(), jwtHandler.generateJwt(user.getName(), new HashMap<>())));
        } catch (Exception e) {
            if (e.getMessage().contains("JWT expired")) {
                return ResponseEntity.ok().body(new LoginResponse(null, null, "INVALID"));
            } else throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authorization failed");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String name) {
        return userEntityToUserDetails(userRepository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found with this email")));
    }

    private UserDetails userEntityToUserDetails(UserEntity userEntity) {
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return userEntity.getPassword();
            }

            @Override
            public String getUsername() {
                return userEntity.getName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}
