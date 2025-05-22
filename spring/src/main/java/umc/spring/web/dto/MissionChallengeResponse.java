package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;
import umc.spring.domain.enums.MissionStatus;

import java.time.LocalDateTime;

@Getter
@Builder
public class MissionChallengeResponse {
    private Long challengeId;
    private Long memberId;
    private Long missionId;
    private MissionStatus status;
    private LocalDateTime createdAt;
}
