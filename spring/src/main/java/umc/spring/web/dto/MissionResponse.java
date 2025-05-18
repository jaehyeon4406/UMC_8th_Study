package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionResponse {
    private Long id;
    private String missionSpec;
    private Integer reward;
    private String storeName;
}