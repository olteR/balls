package olter.balls.users.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@NoArgsConstructor
public class JwtHandler {
    private final int JWT_EXP_TIME = 1200000;
    @Value("${jwt.secret}")
    private final String SECRET = "secret";
    private final String ISSUER = "Balls_Security";
    private final String AUDIENCE = "Balls";
    private static final SignatureAlgorithm ALGORITHM = SignatureAlgorithm.HS512;

    public String generateJwt(String username, Map<String, Object> data) {
        long now = System.currentTimeMillis();
        JwtBuilder jwtBuilder = Jwts.builder()
                .addClaims(data)
                .setNotBefore(new Date(now))
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + JWT_EXP_TIME))
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

