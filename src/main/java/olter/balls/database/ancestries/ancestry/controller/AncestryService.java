package olter.balls.database.ancestries.ancestry.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.exception.ResourceNotFoundException;
import olter.balls.database.ancestries.ancestry.AncestryMapper;
import olter.balls.database.ancestries.ancestry.dto.AncestryDetailsResponse;
import olter.balls.database.ancestries.ancestry.dto.AncestryListResponse;
import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import olter.balls.database.ancestries.ancestry.model.AncestryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AncestryService {
  private final AncestryRepository ancestryRepository;
  private final AncestryMapper ancestryMapper;

  public AncestryDetailsResponse getAncestry(Integer id) {
    Optional<AncestryEntity> entity = ancestryRepository.findById(id);
    if (entity.isPresent()) {
      return ancestryMapper.entityToDetailsResponse(entity.get());
    } else throw new ResourceNotFoundException("no ancestry with such id");
  }

  public List<AncestryListResponse> getAncestries() {
    return ancestryRepository.findAll().stream().map(ancestryMapper::entityToListResponse).toList();
  }
}