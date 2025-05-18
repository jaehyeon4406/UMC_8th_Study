package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.service.MissionChallengeService.MissionChallengeCommandService;
import umc.spring.web.dto.MissionChallengeRequest;
import umc.spring.web.dto.MissionChallengeResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionChallengeRestController {

    private final MissionChallengeCommandService missionChallengeCommandService;

    @PostMapping("/{memberId}/challenge")
    public ResponseEntity<MissionChallengeResponse> challengeMission(
            @PathVariable Long memberId,
            @RequestBody @Valid MissionChallengeRequest request) {
        return ResponseEntity.ok(missionChallengeCommandService.challengeMission(memberId, request));
    }
}