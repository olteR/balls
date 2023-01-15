package olter.balls.users.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balls_generator")
    @SequenceGenerator(name = "balls_generator", sequenceName = "balls_id_seq", initialValue = 1000000, allocationSize = 1)
    private int id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String name;
    private String password;
}