package olter.balls.characters;

import olter.balls.characters.dto.CharacterResponse;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterResponse entityToResponse(CharacterEntity entity);
    List<CharacterResponse> entityToResponseList(List<CharacterEntity> entities);
}
