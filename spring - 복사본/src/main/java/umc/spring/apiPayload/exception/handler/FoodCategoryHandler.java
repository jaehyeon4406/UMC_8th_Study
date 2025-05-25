package umc.spring.apiPayload.exception.handler;

import lombok.Getter;
import umc.spring.apiPayload.code.status.ErrorStatus;

@Getter
public class FoodCategoryHandler extends RuntimeException {

    private final ErrorStatus errorStatus;

    public FoodCategoryHandler(ErrorStatus errorStatus) {
        super(errorStatus.getMessage()); // RuntimeException은 String 메시지를 받음
        this.errorStatus = errorStatus;
    }

}

