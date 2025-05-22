package umc.spring.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder                    // ✅ 이 한 줄이 있어야 builder() 호출 가능
public class MissionResponse {

    @Schema(example = "10")
    private final Long missionId;

    @Schema(example = "5")
    private final Long storeId;

    @Schema(example = "12000원 이상 주문하기")
    private final String missionSpec;

    @Schema(example = "500")
    private final Integer reward;

    private final LocalDateTime createdAt;
}
