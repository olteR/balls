package olter.balls.database.feats.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.core.SourcedEntity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "feats")
public class FeatEntity extends SourcedEntity {
    private String name;
}
