package olter.balls.characters;

import jakarta.persistence.*;
import lombok.Data;
import olter.balls.common.BaseEntity;
import olter.balls.connections.campaign_users.CampaignUserEntity;
import olter.balls.database.dnd.backgrounds.BackgroundEntity;
import olter.balls.database.dnd.classes.ClassEntity;
import olter.balls.database.dnd.races.RaceEntity;
import olter.balls.rulesets.RulesetEntity;
import olter.balls.users.UserEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
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

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity characterClass;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private RaceEntity race;

    @ManyToMany(mappedBy = "characters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CampaignUserEntity> campaigns;
}
