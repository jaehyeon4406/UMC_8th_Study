package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;                 // ✅ 추가
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.validation.annotation.ExistStoreId;
import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponse> createReview(          // ✅ 반환형 변경
                                                              @PathVariable @ExistStoreId Long storeId,
                                                              @RequestBody @Valid ReviewRequest request) {

        ReviewResponse result = reviewCommandService.createReview(storeId, request);
        return ApiResponse.onSuccess(result);                 // ✅ 래핑
    }
}
