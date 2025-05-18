package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}/missions")
    public ResponseEntity<MissionResponse> createMission(
            @PathVariable Long storeId,
            @RequestBody @Valid MissionRequest request
    ) {
        MissionResponse response = missionCommandService.createMission(storeId, request);
        return ResponseEntity.ok(response);
    }
}
