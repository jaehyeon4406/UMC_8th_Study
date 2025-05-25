package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository mmRepo;

    @Override
    public List<MemberMission> getProgressMission(Long memberId, Pageable pageable) {
        Page<MemberMission> page = mmRepo.findByMemberIdAndStatus(
                memberId, MissionStatus.CHALLENGING, pageable);
        return page.getContent();
    }
}
