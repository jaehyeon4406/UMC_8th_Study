package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewResponse {
    private Long id;
    private String content;
    private float score;
    private String storeName;
}
