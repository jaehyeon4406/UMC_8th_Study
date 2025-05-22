package umc.spring.converter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequest;
import umc.spring.web.dto.StoreResponse;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StoreConverter {

    /* Entity 변환 */
    public static Store toEntity(StoreRequest req, Region region) {
        return Store.builder()
                .name(req.getName())
                .address(req.getAddress())
                .region(region)
                .build();
    }

    /* 단건 DTO */
    public static StoreResponse toResponse(Store store) {
        return StoreResponse.builder()
                .storeId(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .regionId(store.getRegion().getId())
                .createdAt(store.getCreatedAt())
                .build();
    }
}
