package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.service.MemberMissionService.MemberMissionQueryService;
import umc.spring.service.ReviewService.ReviewQueryService;
import umc.spring.validation.annotation.PageParam;
import umc.spring.web.dto.MemberMissionListResponse;
import umc.spring.web.dto.ReviewListResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberReviewMissionRestController {

    private final ReviewQueryService reviewQueryService;
    private final MemberMissionQueryService memberMissionQueryService;
    private final MemberMissionCommandService memberMissionCommandService;

    // 내가 작성한 리뷰 목록
    @Operation(summary = "내가 남긴 리뷰 목록 조회 (10건 페이징)")
    @GetMapping("/{memberId}/reviews")
    public ApiResponse<List<ReviewListResponse>> myReviews(
            @PathVariable Long memberId,
            @PageParam @Parameter(example = "1") Integer page) {

        var reviews = reviewQueryService.getMyReviews(
                memberId, PageRequest.of(page, 10));
        return ApiResponse.onSuccess(
                ReviewConverter.toListResponse(reviews));
    }

    // 진행중 미션 목록
    @Operation(summary = "진행 중인 미션 목록 조회 (10건 페이징)")
    @GetMapping("/{memberId}/missions/progress")
    public ApiResponse<List<MemberMissionListResponse>> myProgressMissions(
            @PathVariable Long memberId,
            @PageParam @Parameter(example = "1") Integer page) {

        var missions = memberMissionQueryService.getProgressMission(
                memberId, PageRequest.of(page, 10));

        return ApiResponse.onSuccess(MemberMissionConverter.toResponse(missions));
    }

    // 진행중 → 완료
    @Operation(summary = "진행 중 미션 -> 완료 처리 (10건 페이징)")
    @PatchMapping("/mission-challenges/{challengeId}/complete")
    public ApiResponse<Void> completeMission(
            @PathVariable Long challengeId) {

        memberMissionCommandService.completeChallenge(challengeId);
        return ApiResponse.onSuccess(null);
    }

}
