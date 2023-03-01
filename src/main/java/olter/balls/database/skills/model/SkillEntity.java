package olter.balls.database.skills.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.actions.model.ActionEntity;
import olter.balls.database.core.SourcedEntity;
import olter.balls.database.core.enums.AbilityScoreEnum;
import olter.balls.database.traits.model.TraitEntity;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "skills")
public class SkillEntity extends SourcedEntity {
    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private AbilityScoreEnum keyAbility;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "skill_trained_actions",
            joinColumns = {@JoinColumn(name = "skill_id")},
            inverseJoinColumns = {@JoinColumn(name = "action_id")})
    private List<ActionEntity> trainedActions;
}
