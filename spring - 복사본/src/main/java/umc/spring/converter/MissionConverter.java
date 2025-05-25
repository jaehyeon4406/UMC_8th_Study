package umc.spring.converter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionListResponse;
import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MissionConverter {

    /* ===== Entity 변환 ===== */
    public static Mission toEntity(Member member, Store store, MissionRequest request) {
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .member(member)
                .store(store)
                .build();
    }

    /* ===== 단건 DTO ===== */
    public static MissionResponse toResponse(Mission mission) {
        return MissionResponse.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    /* ===== 목록 DTO ===== */
    public static List<MissionListResponse> toListResponse(List<Mission> missions) {
        return missions.stream()
                .map(m -> MissionListResponse.builder()
                        .missionId(m.getId())
                        .spec(m.getMissionSpec())
                        .reward(m.getReward())
                        .success(null)           // 가게 미션 목록에선 성공 여부 X
                        .build())
                .collect(Collectors.toList());
    }
}
