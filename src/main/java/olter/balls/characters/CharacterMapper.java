package olter.balls.characters;

import olter.balls.characters.dto.CharacterResponse;
import olter.balls.common.NameResponse;
import olter.balls.connections.campaign_users.CampaignUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    @Mapping(target = "characterClass", ignore = true)
    CharacterResponse entityToResponse(CharacterEntity entity);
    List<CharacterResponse> entityToResponseList(List<CharacterEntity> entities);
    NameResponse entityToNameResponse(CharacterEntity entity);
    List<NameResponse> entityToNameResponseList(List<CharacterEntity> entities);
}
