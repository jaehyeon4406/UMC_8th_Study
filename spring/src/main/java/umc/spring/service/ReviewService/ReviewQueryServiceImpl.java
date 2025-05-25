package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository;

import java.util.List;

@Service                           // ← 반드시 있어야 Bean 등록됨
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getMyReviews(Long memberId, Pageable pageable) {
        return reviewRepository.findByMemberId(memberId, pageable)
                .getContent();
    }
}
