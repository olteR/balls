package olter.balls.users.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import olter.balls.users.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtFilter extends HttpFilter {

	private final UserService userService;
	private final JwtHandler jwtHandler;

	@Override
	public void doFilter(
			HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			JwtAuthenticationToken jwt = new JwtAuthenticationToken(authHeader.substring(7));
			try {
				UserDetails user =
						userService.loadUserByUsername(
								jwtHandler.getUsernameFromToken(jwt.getJwt()));
				jwt.setUsername(user.getUsername());
				SecurityContextHolder.getContext().setAuthentication(jwt);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		filterChain.doFilter(request, response);
	}
}
