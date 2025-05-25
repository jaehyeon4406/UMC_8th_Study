package umc.spring.service.ReviewService;

import org.springframework.data.domain.Pageable;
import umc.spring.domain.Review;

import java.util.List;

public interface ReviewQueryService {
    List<Review> getMyReviews(Long memberId, Pageable pageable);
}
