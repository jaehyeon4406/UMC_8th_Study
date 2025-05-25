package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberMissionResponse {
    private Long challengeId;
    private Long missionId;
    private Long memberId;
    private boolean success;
}
