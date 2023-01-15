package olter.balls.users.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userid_generator")
    @SequenceGenerator(name = "userid_generator", initialValue = 1000000, allocationSize = 1)
    private int id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String name;
    private String password;
}