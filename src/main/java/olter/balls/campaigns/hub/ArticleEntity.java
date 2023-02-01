package olter.balls.campaigns.hub;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.campaigns.CampaignEntity;
import olter.balls.common.BaseEntity;
import olter.balls.users.UserEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "articles")
public class ArticleEntity extends BaseEntity {
    private String title;
    private boolean featured;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article")
    private List<SegmentEntity> segments;

    @ManyToOne(fetch = FetchType.LAZY)
    private CampaignEntity campaign;

    @ManyToOne(fetch = FetchType.LAZY)
    private ArticleCategoryEntity category;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "article_visibility",
            joinColumns = {@JoinColumn(name = "article_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<UserEntity> visibleToUsers;
}
