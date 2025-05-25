package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberMissionListResponse {
    private Long   challengeId;
    private String storeName;
    private String spec;
    private Integer reward;
    private boolean success;
}
