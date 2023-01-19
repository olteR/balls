package olter.balls.rulesets;

import jakarta.persistence.*;
import lombok.Data;
import olter.balls.campaigns.CampaignEntity;
import olter.balls.characters.CharacterEntity;
import olter.balls.common.BaseEntity;

import java.util.List;

@Entity
@Data
@Table(name = "rulesets")
public class RulesetEntity extends BaseEntity {
    @Column(unique = true)
    private String name;
    private String shortName;
    private Integer coreDice;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ruleset")
    private List<CampaignEntity> campaigns;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ruleset")
    private List<CharacterEntity> characters;
}
