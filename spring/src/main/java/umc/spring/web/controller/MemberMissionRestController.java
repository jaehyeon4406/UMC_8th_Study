package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;                         // ✅ 추가
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.web.dto.MemberMissionRequest;
import umc.spring.web.dto.MemberMissionResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/{memberId}/challenge")
    public ApiResponse<MemberMissionResponse> challengeMission( // ✅ 반환형 변경
                                                                @PathVariable Long memberId,
                                                                @RequestBody @Valid MemberMissionRequest request) {

        return ApiResponse.onSuccess(                               // ✅ 래핑
                memberMissionCommandService.challengeMission(memberId, request)
        );
    }
}
