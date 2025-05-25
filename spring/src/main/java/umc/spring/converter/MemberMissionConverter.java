package umc.spring.converter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionListResponse;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMissionConverter {

    public static List<MemberMissionListResponse> toResponse(List<MemberMission> list) {
        return list.stream()
                .map(mm -> MemberMissionListResponse.builder()
                        .challengeId(mm.getId())
                        .storeName(mm.getMission().getStore().getName())
                        .spec(mm.getMission().getMissionSpec())
                        .reward(mm.getMission().getReward())
                        .success(mm.getStatus() == MissionStatus.COMPLETE)
                        .build())
                .collect(Collectors.toList());
    }
}
