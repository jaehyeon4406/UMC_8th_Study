package umc.spring.service.MissionService;

import org.springframework.data.domain.Pageable;
import umc.spring.domain.Mission;

import java.util.List;

/** 특정 가게의 미션 목록을 읽어오는 Query 전용 서비스 */
public interface MissionQueryService {
    List<Mission> getStoreMissions(Long storeId, Pageable pageable);
}
