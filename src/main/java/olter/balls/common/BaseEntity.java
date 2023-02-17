package olter.balls.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@MappedSuperclass
public class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balls_generator")
  @SequenceGenerator(
      name = "balls_generator",
      sequenceName = "balls_id_seq",
      initialValue = 1000000,
      allocationSize = 1)
  private Integer id;
}
