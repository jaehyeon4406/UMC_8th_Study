package umc.spring.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MissionRequest {

    @NotBlank
    private String missionSpec;

    @NotNull
    private Integer reward;

    @Future
    @NotNull
    private LocalDateTime deadline;
}
