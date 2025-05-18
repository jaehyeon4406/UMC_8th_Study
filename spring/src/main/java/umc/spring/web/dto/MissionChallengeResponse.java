package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionChallengeResponse {
    private Long id;
    private String missionSpec;
    private String status;
}