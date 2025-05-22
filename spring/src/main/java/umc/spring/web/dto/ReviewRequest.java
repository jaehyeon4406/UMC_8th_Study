package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private Float rating;
}