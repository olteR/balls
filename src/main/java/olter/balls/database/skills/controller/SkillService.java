package olter.balls.database.skills.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.exception.ResourceNotFoundException;
import olter.balls.database.ancestries.ancestry.dto.AncestryDetailsResponse;
import olter.balls.database.ancestries.ancestry.dto.AncestryListResponse;
import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import olter.balls.database.skills.SkillMapper;
import olter.balls.database.skills.dto.SkillDetailsResposne;
import olter.balls.database.skills.dto.SkillListResponse;
import olter.balls.database.skills.model.SkillEntity;
import olter.balls.database.skills.model.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    public SkillDetailsResposne getSkill(Long id) {
        Optional<SkillEntity> entity = skillRepository.findById(id);
        if (entity.isPresent()) {
            return skillMapper.entityToDetailsResponse(entity.get());
        } else throw new ResourceNotFoundException("no ancestry with such id");
    }

    public List<SkillListResponse> getSkills() {
        return skillRepository.findAll().stream().map(skillMapper::entityToListResponse).toList();
    }
}
