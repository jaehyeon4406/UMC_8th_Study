package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

/** 샘플(Temp) 예외 래퍼 – 실제 사용하지 않을 거면 파일을 삭제해도 무방 */
public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

    @Override                      // ❗ GeneralException 이 요구하는 추상 메서드
    public BaseErrorCode getErrorCode() {
        return getCode();          // Lombok @Getter 로 생성된 getCode()
    }
}
