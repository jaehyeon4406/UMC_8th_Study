package umc.spring.service.ReviewService;

import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

public interface ReviewCommandService {
    ReviewResponse createReview(Long storeId, ReviewRequest request);
}
