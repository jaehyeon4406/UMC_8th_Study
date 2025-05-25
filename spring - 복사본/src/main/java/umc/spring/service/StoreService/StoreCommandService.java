package umc.spring.service.StoreService;

import umc.spring.web.dto.StoreRequest;
import umc.spring.web.dto.StoreResponse;

public interface StoreCommandService {
    StoreResponse createStore(Long regionId, StoreRequest request);
}
