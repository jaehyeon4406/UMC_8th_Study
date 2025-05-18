package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<ReviewResponse> createReview(
            @PathVariable @ExistStoreId Long storeId,
            @RequestBody @Valid ReviewRequest request) {
        return ResponseEntity.ok(reviewCommandService.createReview(storeId, request));
    }
}