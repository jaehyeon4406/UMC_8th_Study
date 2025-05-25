package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.exception.notfound.MemberNotFoundException;
import umc.spring.apiPayload.exception.notfound.StoreNotFoundException;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository  storeRepository;
    private final MemberRepository memberRepository;

    /** 가게에 리뷰 작성 */
    @Override
    @Transactional
    public ReviewResponse createReview(Long storeId, ReviewRequest request) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(StoreNotFoundException::new);

        // 인증 기반인 경우 SecurityContext 등에서 id 추출. 예시는 1L 고정
        Member member = memberRepository.findById(1L)
                .orElseThrow(MemberNotFoundException::new);

        Review review  = ReviewConverter.toEntity(request, store, member);
        Review saved   = reviewRepository.save(review);

        return ReviewConverter.toResponse(saved);
    }
}
