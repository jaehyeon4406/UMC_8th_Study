package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoreResponse {
    private Long id;
    private String name;
    private String address;
    private String regionName;
}
