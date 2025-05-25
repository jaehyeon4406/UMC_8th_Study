package umc.spring.service.MissionService;

import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;

public interface MissionCommandService {
    MissionResponse createMission(Long storeId, MissionRequest request);
}

