package olter.balls.characters;

import olter.balls.characters.dto.CharacterListResponse;
import olter.balls.common.NameResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    default CharacterListResponse entityToResponse(CharacterEntity entity) {
        CharacterListResponse response = new CharacterListResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());

        if (entity.getAncestry() != null) {
            NameResponse ancestry = new NameResponse();
            ancestry.setId(entity.getAncestry().getId());
            ancestry.setName(entity.getAncestry().getName());
            response.setAncestry(ancestry);
        }

        List<NameResponse> campaigns = new ArrayList<>();
        entity.getCampaigns().forEach(cu -> {
            NameResponse campaign = new NameResponse();
            campaign.setId(cu.getCampaign().getId());
            campaign.setName(cu.getCampaign().getName());
            campaigns.add(campaign);
        });
        response.setCampaigns(campaigns);
        return response;
    }
    List<CharacterListResponse> entityToResponseList(List<CharacterEntity> entities);
}
