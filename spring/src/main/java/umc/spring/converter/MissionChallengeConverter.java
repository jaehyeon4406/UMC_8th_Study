package umc.spring.converter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.MissionChallenge;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.MissionChallengeListResponse;
import umc.spring.web.dto.MissionChallengeResponse;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MissionChallengeConverter {

    /*==== Entity 변환 ====*/
    /** Member + Mission → MissionChallenge 엔티티 */
    public static MissionChallenge toEntity(Member member, Mission mission) {
        return MissionChallenge.builder()
                .member(member)
                .mission(mission)
                .build();
    }

    /*==== 단건 Response 변환 ====*/
    public static MissionChallengeResponse toResponse(MissionChallenge mc) {
        return MissionChallengeResponse.builder()
                .challengeId(mc.getId())
                .memberId(mc.getMember().getId())
                .missionId(mc.getMission().getId())
                .status(mc.getStatus())
                .createdAt(mc.getCreatedAt())
                .build();
    }

    /*==== 목록 Response 변환 ====*/
    public static List<MissionChallengeListResponse> toResponse(List<MissionChallenge> list) {
        return list.stream()
                .map(mc -> MissionChallengeListResponse.builder()
                        .challengeId(mc.getId())
                        .storeName(mc.getMission().getStore().getName())
                        .spec(mc.getMission().getMissionSpec())
                        .reward(mc.getMission().getReward())
                        .success(mc.getStatus() == MissionStatus.COMPLETE)
                        .build())
                .collect(Collectors.toList());
    }
}
