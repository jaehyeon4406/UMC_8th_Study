package umc.spring.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder                  // ✅ builder() 메서드 생성
public class ReviewResponse {

    @Schema(example = "15")
    private final Long reviewId;

    @Schema(example = "7")
    private final Long memberId;

    @Schema(example = "5")
    private final Long storeId;

    @Schema(example = "4.5")
    private final Double rating;

    @Schema(example = "또 방문하고 싶어요!")
    private final String content;

    private final LocalDateTime createdAt;
}
