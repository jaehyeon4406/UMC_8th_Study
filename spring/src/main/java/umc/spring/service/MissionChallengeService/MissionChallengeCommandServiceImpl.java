package umc.spring.service.MissionChallengeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.converter.MissionChallengeConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.MissionChallenge;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionChallengeRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionChallengeRequest;
import umc.spring.web.dto.MissionChallengeResponse;

@Service
@RequiredArgsConstructor
public class MissionChallengeCommandServiceImpl implements MissionChallengeCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MissionChallengeRepository missionChallengeRepository;

    @Override
    @Transactional
    public MissionChallengeResponse challengeMission(Long memberId, MissionChallengeRequest request) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        MissionChallenge missionChallenge = MissionChallengeConverter.toEntity(member, mission);
        missionChallengeRepository.save(missionChallenge);

        return MissionChallengeConverter.toResponse(missionChallenge);
    }
}
