package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.MissionChallenge;
import umc.spring.web.dto.MissionChallengeResponse;

public class MissionChallengeConverter {

    public static MissionChallenge toEntity(Member member, Mission mission) {
        return MissionChallenge.builder()
                .member(member)
                .mission(mission)
                .build();
    }

    public static MissionChallengeResponse toResponse(MissionChallenge missionChallenge) {
        return new MissionChallengeResponse(
                missionChallenge.getId(),
                missionChallenge.getMission().getMissionSpec(),
                missionChallenge.getStatus().name()
        );
    }
}