package umc.spring.service.MissionChallengeService;

import umc.spring.web.dto.MissionChallengeRequest;
import umc.spring.web.dto.MissionChallengeResponse;

public interface MissionChallengeCommandService {
    MissionChallengeResponse challengeMission(Long memberId, MissionChallengeRequest request);
    /** 진행중 → 완료 전환 */
    void completeChallenge(Long challengeId);
}
