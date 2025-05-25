package umc.spring.service.MemberMissionService;

import org.springframework.data.domain.Pageable;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionQueryService {
    List<MemberMission> getProgressMission(Long memberId, Pageable pageable);
}
