package olter.balls.connections.campaign_users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.campaigns.CampaignEntity;
import olter.balls.characters.CharacterEntity;
import olter.balls.common.BaseEntity;
import olter.balls.users.UserEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "campaign_users")
public class CampaignUserEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private CampaignEntity campaign;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "campaign_characters",
            joinColumns = {@JoinColumn(name = "campaign_users_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")})
    private List<CharacterEntity> characters;

    @Enumerated(EnumType.STRING)
    private CampaignUserConnectionEnum role;
}
