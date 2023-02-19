package olter.balls.characters;

import java.util.ArrayList;
import java.util.List;
import olter.balls.characters.dto.CharacterListResponse;
import olter.balls.characters.model.CharacterEntity;
import olter.balls.common.NameResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
  default CharacterListResponse entityToResponse(CharacterEntity entity) {
    CharacterListResponse response = new CharacterListResponse();
    response.setId(entity.getId());
    response.setName(entity.getName());
    response.setAncestry(
        entity.getAncestry() != null
            ? new NameResponse(entity.getAncestry().getId(), entity.getAncestry().getName())
            : null);

    List<NameResponse> campaigns = new ArrayList<>();
    entity
        .getCampaigns()
        .forEach(
            cu -> {
              campaigns.add(new NameResponse(cu.getCampaign().getId(), cu.getCampaign().getName()));
            });
    response.setCampaigns(campaigns);
    return response;
  }
}
