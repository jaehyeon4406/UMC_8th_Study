package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.status.ErrorStatus;

public class FoodCategoryHandler extends RuntimeException {

    private final ErrorStatus errorStatus;

    public FoodCategoryHandler(ErrorStatus errorStatus) {
        super(errorStatus.getMessage()); // RuntimeException은 String 메시지를 받음
        this.errorStatus = errorStatus;
    }

    public ErrorStatus getErrorStatus() {
        return errorStatus;
    }
}

