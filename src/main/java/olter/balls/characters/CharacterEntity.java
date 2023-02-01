package olter.balls.characters;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import olter.balls.common.BaseEntity;
import olter.balls.connections.campaign_users.CampaignUserEntity;
import olter.balls.database.ancestries.AncestryEntity;
import olter.balls.users.UserEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "characters")
public class CharacterEntity extends BaseEntity {
    private String name;
    private Integer level;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity owner;

//    @ManyToOne
//    @JoinColumn(name = "background_id")
//    private BackgroundEntity background;

//    @ManyToOne
//    @JoinColumn(name = "class_id")
//    private ClassEntity characterClass;

    @ManyToOne
    @JoinColumn(name = "ancestry_id")
    private AncestryEntity ancestry;

    @ManyToMany(mappedBy = "characters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CampaignUserEntity> campaigns;
}
