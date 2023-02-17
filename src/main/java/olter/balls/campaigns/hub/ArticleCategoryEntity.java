package olter.balls.campaigns.hub;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.BaseEntity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "article_categories")
public class ArticleCategoryEntity extends BaseEntity {
  @Column(unique = true)
  private String name;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
  private List<ArticleEntity> articles;
}
