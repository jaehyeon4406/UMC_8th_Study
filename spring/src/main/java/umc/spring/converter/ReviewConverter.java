package umc.spring.converter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewListResponse;
import umc.spring.web.dto.ReviewResponse;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewConverter {

    /* ===== 목록용 DTO ===== */
    public static List<ReviewListResponse> toListResponse(List<Review> reviews) {
        return reviews.stream()
                .map(r -> ReviewListResponse.builder()
                        .reviewId(r.getId())
                        .rating(Double.valueOf(r.getScore()))   // Float → Double 변환
                        .content(r.getContent())
                        .createdAt(r.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

    /* ===== 단건용 DTO ===== */
    public static ReviewResponse toResponse(Review review) {
        return ReviewResponse.builder()
                .reviewId(review.getId())
                .memberId(review.getMember().getId())
                .storeId(review.getStore().getId())
                .rating(Double.valueOf(review.getScore()))
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .build();
    }

    /* ===== Entity 변환 ===== */
    public static Review toEntity(umc.spring.web.dto.ReviewRequest req,
                                  umc.spring.domain.Store store,
                                  umc.spring.domain.Member member) {

        return Review.builder()
                .title(req.getTitle())
                .content(req.getContent())
                .score(req.getRating())      // rating(Float) → score(Float)
                .store(store)
                .member(member)
                .build();
    }
}
