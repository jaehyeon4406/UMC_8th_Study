package umc.spring.service.MemberMissionService;

import umc.spring.web.dto.MemberMissionRequest;
import umc.spring.web.dto.MemberMissionResponse;

public interface MemberMissionCommandService {
    MemberMissionResponse challengeMission(Long memberId, MemberMissionRequest req);
    void completeChallenge(Long challengeId);
}
