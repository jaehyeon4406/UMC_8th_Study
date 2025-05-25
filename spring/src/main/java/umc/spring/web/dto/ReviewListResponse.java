package umc.spring.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReviewListResponse {
    @Schema(example = "10")  private Long reviewId;
    @Schema(example = "4.5") private Double rating;
    @Schema(example = "다음에 또 올게요!") private String content;
    private LocalDateTime createdAt;
}
