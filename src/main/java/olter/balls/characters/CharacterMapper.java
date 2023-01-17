package olter.balls.characters;

import olter.balls.campaigns.CampaignEntity;
import olter.balls.campaigns.dto.CampaignResponse;
import olter.balls.characters.dto.CharacterResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterResponse entityToResponse(CharacterEntity entity);
    List<CharacterResponse> entityToResponseList(List<CharacterEntity> entities);
}