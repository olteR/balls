package olter.balls.database.core.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Embeddable
public class FeatureEmbeddable {
    private String name;

    @Column(columnDefinition="TEXT")
    private String entry;
}
