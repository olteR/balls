package olter.balls.users.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class JwtAuthenticationToken implements Authentication {

  private final Collection<GrantedAuthority> authorities;
  private final boolean authenticated;
  private final String jwt;
  private String username;
  private final Map<String, Object> details;

  public JwtAuthenticationToken(String jwt) {
    this.jwt = jwt;
    this.authenticated = true;
    this.authorities = new ArrayList<>();
    this.username = null;
    this.details = null;
  }

  public String getJwt() {
    return jwt;
  }

  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public void addAuthority(GrantedAuthority authority) {
    authorities.add(authority);
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getDetails() {
    return details;
  }

  public Map<String, Object> getJwtData() {
    return details;
  }

  @Override
  public Object getPrincipal() {
    return username;
  }

  @Override
  public boolean isAuthenticated() {
    return authenticated;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    throw new IllegalArgumentException("Don't ever call this method my dude.");
  }

  @Override
  public String getName() {
    return username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
