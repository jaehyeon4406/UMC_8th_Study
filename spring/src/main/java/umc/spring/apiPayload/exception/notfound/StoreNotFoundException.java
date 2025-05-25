package umc.spring.apiPayload.exception.notfound;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;

public class StoreNotFoundException extends GeneralException {

    public StoreNotFoundException() {
        super(ErrorStatus.STORE_NOT_FOUND);  // GeneralException 생성자 호출
    }

    @Override
    public BaseErrorCode getErrorCode() {
        return ErrorStatus.STORE_NOT_FOUND;  // 추상 메서드 구현 필수!
    }
}
