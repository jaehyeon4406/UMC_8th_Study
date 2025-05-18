package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.NotAlreadyChallenge;

@Getter
@NotAlreadyChallenge
public class MissionChallengeRequest {

    @NotNull
    private Long missionId;
}