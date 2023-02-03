package olter.balls.database.ancestries;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.database.ancestries.dto.AncestryListResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AncestryService {
    private final AncestryRepository ancestryRepository;
    private final AncestryMapper ancestryMapper;

    public List<AncestryListResponse> getAncestries() {
        return ancestryMapper.entityToListResponseList(ancestryRepository.findAll());
    }
}
