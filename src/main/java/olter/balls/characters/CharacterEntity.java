package olter.balls.characters;

import jakarta.persistence.*;
import lombok.Data;
import olter.balls.campaigns.CampaignEntity;
import olter.balls.rulesets.RulesetEntity;
import olter.balls.users.user.UserEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "characters")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balls_generator")
    @SequenceGenerator(name = "balls_generator", sequenceName = "balls_id_seq", initialValue = 1000000, allocationSize = 1)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "ruleset_id")
    private RulesetEntity ruleset;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<CampaignEntity> campaigns = new HashSet<>();
}