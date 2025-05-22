package umc.spring.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder                    // ✅ builder() 메서드 생성
public class StoreResponse {

    @Schema(example = "12")
    private final Long storeId;

    @Schema(example = "만나분식")
    private final String name;

    @Schema(example = "서울특별시 성동구 왕십리로")
    private final String address;

    @Schema(example = "3")
    private final Long regionId;

    private final LocalDateTime createdAt;
}
