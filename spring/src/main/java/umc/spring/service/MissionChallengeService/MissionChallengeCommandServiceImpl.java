package umc.spring.service.MissionChallengeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.exception.notfound.MemberNotFoundException;
import umc.spring.apiPayload.exception.notfound.MissionChallengeNotFoundException;
import umc.spring.apiPayload.exception.notfound.MissionNotFoundException;
import umc.spring.converter.MissionChallengeConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.MissionChallenge;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionChallengeRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionChallengeRequest;
import umc.spring.web.dto.MissionChallengeResponse;

/**
 * 미션 도전·완료를 담당하는 Command 서비스 구현체
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionChallengeCommandServiceImpl implements MissionChallengeCommandService {

    private final MemberRepository             memberRepo;
    private final MissionRepository            missionRepo;
    private final MissionChallengeRepository   challengeRepo;

    /** 미션 도전 */
    @Override
    @Transactional
    public MissionChallengeResponse challengeMission(Long memberId, MissionChallengeRequest request) {

        Member member = memberRepo.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);

        Mission mission = missionRepo.findById(request.getMissionId())
                .orElseThrow(MissionNotFoundException::new);

        MissionChallenge mc = MissionChallengeConverter.toEntity(member, mission);
        challengeRepo.save(mc);

        return MissionChallengeConverter.toResponse(mc);
    }

    /** 진행 중 미션을 완료 상태로 전환 */
    @Override
    @Transactional
    public void completeChallenge(Long challengeId) {

        MissionChallenge mc = challengeRepo.findById(challengeId)
                .orElseThrow(MissionChallengeNotFoundException::new);

        mc.complete();   // 엔티티 비즈니스 로직
    }
}
