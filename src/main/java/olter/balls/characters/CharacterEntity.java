package olter.balls.characters;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import olter.balls.common.BaseEntity;
import olter.balls.connections.campaign_users.CampaignUserEntity;
import olter.balls.connections.character_classes.CharacterClassEntity;
import olter.balls.database.dnd.backgrounds.BackgroundEntity;
import olter.balls.database.dnd.classes.ClassEntity;
import olter.balls.database.dnd.races.RaceEntity;
import olter.balls.rulesets.RulesetEntity;
import olter.balls.users.UserEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "characters")
public class CharacterEntity extends BaseEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name = "ruleset_id")
    private RulesetEntity ruleset;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity owner;

    @ManyToOne
    @JoinColumn(name = "background_id")
    private BackgroundEntity background;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "character")
    private List<CharacterClassEntity> classes;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private RaceEntity race;

    @ManyToMany(mappedBy = "characters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CampaignUserEntity> campaigns;
}
