package olter.balls.database.ancestries.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AncestryListResponse {
	private Integer id;
	private String name;
	private String rarity;
	private String source;
}
