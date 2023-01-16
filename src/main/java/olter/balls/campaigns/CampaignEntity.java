package olter.balls.campaigns;

import jakarta.persistence.*;
import lombok.Data;
import olter.balls.characters.CharacterEntity;
import olter.balls.rulesets.RulesetEntity;
import olter.balls.users.user.UserEntity;

import java.util.Set;

@Entity
@Data
@Table(name = "campaigns")
public class CampaignEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balls_generator")
    @SequenceGenerator(name = "balls_generator", sequenceName = "balls_id_seq", initialValue = 1000000, allocationSize = 1)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "game_master_id")
    private UserEntity gameMaster;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "campaign_characters",
            joinColumns = {@JoinColumn(name = "campaign_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")})
    private Set<CharacterEntity> characters;

    @ManyToOne
    @JoinColumn(name = "ruleset_id")
    private RulesetEntity ruleset;
}
