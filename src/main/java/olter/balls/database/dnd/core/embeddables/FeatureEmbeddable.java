package olter.balls.database.dnd.core.embeddables;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
@Embeddable
public class FeatureEmbeddable {
    private String name;
    private String description;
    private Integer source_book_id;
    private Integer page;
}