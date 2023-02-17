package olter.balls.campaigns.hub.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ArticleListResponse {
  private String title;
  private boolean featured;
}
