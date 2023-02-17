package olter.balls.database.core;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.common.BaseEntity;

@Getter
@Setter
@RequiredArgsConstructor
@MappedSuperclass
public class SourcedEntity extends BaseEntity {
	private String source;
	private Integer page;
}
