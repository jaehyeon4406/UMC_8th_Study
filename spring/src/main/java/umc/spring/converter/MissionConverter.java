package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;

public class MissionConverter {

    public static Mission toEntity(Member member, MissionRequest request, Store store) {
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .store(store)
                .member(member)
                .build();
    }

    public static MissionResponse toResponse(Mission mission) {
        return new MissionResponse(
                mission.getId(),
                mission.getMissionSpec(),
                mission.getReward(),
                mission.getStore().getName()
        );
    }
}
