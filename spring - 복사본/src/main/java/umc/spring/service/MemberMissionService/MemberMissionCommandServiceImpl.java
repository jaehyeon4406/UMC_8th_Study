package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.exception.notfound.MemberNotFoundException;
import umc.spring.apiPayload.exception.notfound.MissionNotFoundException;
import umc.spring.apiPayload.exception.notfound.MemberMissionNotFoundException;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MemberMissionRequest;
import umc.spring.web.dto.MemberMissionResponse;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository        memberRepo;
    private final MissionRepository       missionRepo;
    private final MemberMissionRepository mmRepo;

    @Override @Transactional
    public MemberMissionResponse challengeMission(Long memberId, MemberMissionRequest req) {

        Member  member  = memberRepo.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);
        Mission mission = missionRepo.findById(req.getMissionId())
                .orElseThrow(MissionNotFoundException::new);

        MemberMission mm = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .createdAt(req.getCreatedAt())
                .build();

        mmRepo.save(mm);

        return MemberMissionResponse.builder()
                .challengeId(mm.getId())
                .missionId(mission.getId())
                .memberId(member.getId())
                .success(false)
                .build();
    }

    @Override @Transactional
    public void completeChallenge(Long challengeId) {
        MemberMission mm = mmRepo.findById(challengeId)
                .orElseThrow(MemberMissionNotFoundException::new);
        mm.complete();
    }
}
