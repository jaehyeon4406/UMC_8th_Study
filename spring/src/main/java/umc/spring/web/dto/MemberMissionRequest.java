package umc.spring.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberMissionRequest {
    private Long missionId;
    private java.time.LocalDateTime createdAt;   // 예시용 필드
}
