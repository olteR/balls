package olter.balls.users.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
public class JwtHandler {
  private final int JWT_EXP_TIME = 1200000;

  @Value("${jwt.secret}")
  private final String SECRET = "secret";

  private final String ISSUER = "Balls_Security";
  private final String AUDIENCE = "Balls";
  private static final SignatureAlgorithm ALGORITHM = SignatureAlgorithm.HS512;

  public String generateJwt(String username, Map<String, Object> data) {
    JwtBuilder jwtBuilder =
        Jwts.builder()
            .addClaims(data)
            .setNotBefore(Date.from(ZonedDateTime.now().toInstant()))
            .setIssuedAt(Date.from(ZonedDateTime.now().toInstant()))
            .setExpiration(Date.from(ZonedDateTime.now().plusHours(24).toInstant()))
            .setIssuer(ISSUER)
            .setAudience(AUDIENCE)
            .signWith(ALGORITHM, SECRET);
    if (!data.containsKey("sub")) {
      jwtBuilder.setSubject(username);
    }
    return jwtBuilder.compact();
  }

  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
  }

  private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  public String getUsernameFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }
}
