package olter.balls.characters;

import olter.balls.characters.dto.CharacterResponse;
import olter.balls.common.NameResponse;
import olter.balls.connections.campaign_users.CampaignUserEntity;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    default CharacterResponse entityToResponse(CharacterEntity entity) {
        List<NameResponse> campaigns = new ArrayList<>();

        for (CampaignUserEntity cue : entity.getCampaigns()) {
            NameResponse campaign = new NameResponse();
            campaign.setId(cue.getCampaign().getId());
            campaign.setName(cue.getCampaign().getName());
            campaigns.add(campaign);
        }

        CharacterResponse response = new CharacterResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setCampaigns(campaigns);
        return response;
    }
    List<CharacterResponse> entityToResponseList(List<CharacterEntity> entities);
    NameResponse entityToNameResponse(CharacterEntity entity);
    List<NameResponse> entityToNameResponseList(List<CharacterEntity> entities);
}
