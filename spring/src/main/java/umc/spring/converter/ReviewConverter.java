package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

public class ReviewConverter {

    public static Review toEntity(ReviewRequest request, Store store, Member member) {
        return Review.builder()
                .store(store)
                .member(member)
                .content(request.getContent())
                .score(request.getScore())
                .title(request.getTitle())
                .build();
    }

    public static ReviewResponse toResponse(Review review) {
        return new ReviewResponse(
                review.getId(),
                review.getContent(),
                review.getScore(),
                review.getStore().getName()
        );
    }
}
