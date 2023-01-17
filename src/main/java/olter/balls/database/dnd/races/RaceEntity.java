package olter.balls.database.dnd.races;

import jakarta.persistence.*;
import lombok.Data;
import olter.balls.database.dnd.core.enums.SizeEnum;

@Entity
@Data
@Table(name = "dnddb_races")
public class RaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balls_generator")
    @SequenceGenerator(name = "balls_generator", sequenceName = "balls_id_seq", initialValue = 1000000, allocationSize = 1)
    private Integer id;
    String age;
    String alignment;
    Integer speed;

    @Enumerated(EnumType.STRING)
    SizeEnum size;
}
