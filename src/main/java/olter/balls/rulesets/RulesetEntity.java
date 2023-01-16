package olter.balls.rulesets;

import jakarta.persistence.*;
import lombok.Data;
import olter.balls.campaigns.CampaignEntity;
import olter.balls.characters.CharacterEntity;

import java.util.List;

@Entity
@Data
@Table(name = "rulesets")
public class RulesetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balls_generator")
    @SequenceGenerator(name = "balls_generator", sequenceName = "balls_id_seq", initialValue = 1000000, allocationSize = 1)
    private Integer id;
    @Column(unique = true)
    private String name;
    private String shortName;
    private Integer coreDice;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ruleset")
    private List<CampaignEntity> campaigns;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ruleset")
    private List<CharacterEntity> characters;
}
