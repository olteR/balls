package olter.balls.database.traits.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.exception.ResourceNotFoundException;
import olter.balls.database.traits.TraitMapper;
import olter.balls.database.traits.TraitRepository;
import olter.balls.database.traits.dto.TraitListResponse;
import olter.balls.database.traits.model.TraitEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TraitService {
  private final TraitRepository traitRepository;
  private final TraitMapper traitMapper;

  public TraitListResponse getTrait(Integer id) {
    Optional<TraitEntity> entity = traitRepository.findById(id);
    if (entity.isPresent()) {
      return traitMapper.entityToListResponse(entity.get());
    } else throw new ResourceNotFoundException("no trait with such id");
  }

  public List<TraitListResponse> getTraits() {
    return traitRepository.findAll().stream().map(traitMapper::entityToListResponse).toList();
  }
}
