package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionListResponse {
    private Long missionId;
    private String spec;        // 미션 설명
    private Integer reward;     // 포인트
    private Boolean success;    // 성공 여부
}
