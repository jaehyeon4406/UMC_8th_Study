package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;       // ← ✅ 빠진 Swagger import
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.service.MissionService.MissionQueryService;  // ← ✅ 방금 만든 서비스
import umc.spring.validation.annotation.PageParam;
import umc.spring.web.dto.MissionListResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreMissionRestController {

    private final MissionQueryService missionQueryService;

    // 2. 특정 가게의 미션 목록
    @Operation(summary = "특정 가게의 미션 목록 조회 (10건 페이징)")
    @GetMapping("/{storeId}/missions")
    public ApiResponse<List<MissionListResponse>> missionsByStore(
            @PathVariable Long storeId,
            @PageParam @Parameter(example = "1") Integer page) {

        var missions = missionQueryService.getStoreMissions(
                storeId, PageRequest.of(page, 10));

        return ApiResponse.onSuccess(MissionConverter.toListResponse(missions));
    }
}
