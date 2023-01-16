package olter.balls.users;

import jakarta.persistence.*;
import lombok.*;
import olter.balls.campaigns.CampaignEntity;
import olter.balls.characters.CharacterEntity;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balls_generator")
    @SequenceGenerator(name = "balls_generator", sequenceName = "balls_id_seq", initialValue = 1000000, allocationSize = 1)
    private Integer id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String name;
    private String displayName;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "gameMaster")
    private List<CampaignEntity> leadCampaigns;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "owner")
    private List<CharacterEntity> characters;
}