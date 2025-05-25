package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;           // ✅ 추가
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.StoreRequest;
import umc.spring.web.dto.StoreResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{regionId}/stores")
    public ApiResponse<StoreResponse> createStore(           // ✅ 반환형 변경
                                                             @PathVariable Long regionId,
                                                             @RequestBody @Valid StoreRequest request) {

        StoreResponse response = storeCommandService.createStore(regionId, request);
        return ApiResponse.onSuccess(response);              // ✅ 래핑
    }
}
