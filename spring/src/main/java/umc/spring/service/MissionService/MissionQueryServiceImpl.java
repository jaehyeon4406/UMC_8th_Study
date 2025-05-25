package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepo;

    @Override
    public List<Mission> getStoreMissions(Long storeId, Pageable pageable) {
        return missionRepo.findByStoreId(storeId, pageable).getContent();
    }
}
