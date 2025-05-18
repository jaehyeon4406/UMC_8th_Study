package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.StoreRequest;
import umc.spring.web.dto.StoreResponse;


@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public StoreResponse createStore(Long regionId, StoreRequest request) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));

        Store store = StoreConverter.toEntity(request, region);
        Store saved = storeRepository.save(store);

        return StoreConverter.toResponse(saved);
    }
}
