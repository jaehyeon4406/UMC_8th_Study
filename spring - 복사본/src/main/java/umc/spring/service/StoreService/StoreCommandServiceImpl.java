package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.exception.notfound.RegionNotFoundException;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.StoreRequest;
import umc.spring.web.dto.StoreResponse;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository  storeRepository;
    private final RegionRepository regionRepository;

    /** 지역에 가게 등록 */
    @Override
    @Transactional
    public StoreResponse createStore(Long regionId, StoreRequest request) {

        Region region = regionRepository.findById(regionId)
                .orElseThrow(RegionNotFoundException::new);

        Store store  = StoreConverter.toEntity(request, region);
        Store saved  = storeRepository.save(store);

        return StoreConverter.toResponse(saved);
    }
}
