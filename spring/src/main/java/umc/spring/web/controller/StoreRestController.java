package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.StoreRequest;
import umc.spring.web.dto.StoreResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{regionId}/stores")
    public ResponseEntity<StoreResponse> createStore(
            @PathVariable Long regionId,
            @RequestBody @Valid StoreRequest request
    ) {
        StoreResponse response = storeCommandService.createStore(regionId, request);
        return ResponseEntity.ok(response);
    }
}
