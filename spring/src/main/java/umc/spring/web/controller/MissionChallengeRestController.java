package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;                         // ✅ 추가
import umc.spring.service.MissionChallengeService.MissionChallengeCommandService;
import umc.spring.web.dto.MissionChallengeRequest;
import umc.spring.web.dto.MissionChallengeResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionChallengeRestController {

    private final MissionChallengeCommandService missionChallengeCommandService;

    @PostMapping("/{memberId}/challenge")
    public ApiResponse<MissionChallengeResponse> challengeMission( // ✅ 반환형 변경
                                                                   @PathVariable Long memberId,
                                                                   @RequestBody @Valid MissionChallengeRequest request) {

        return ApiResponse.onSuccess(                               // ✅ 래핑
                missionChallengeCommandService.challengeMission(memberId, request)
        );
    }
}
