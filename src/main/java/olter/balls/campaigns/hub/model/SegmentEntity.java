package olter.balls.campaigns.hub.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.BaseEntity;
import olter.balls.users.UserEntity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "articles")
public class SegmentEntity extends BaseEntity {
  private String title;

  @Column(columnDefinition = "TEXT")
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  private ArticleEntity article;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
      name = "segment_visibility",
      joinColumns = {@JoinColumn(name = "segment_id")},
      inverseJoinColumns = {@JoinColumn(name = "user_id")})
  private List<UserEntity> visibleToUsers;
}
