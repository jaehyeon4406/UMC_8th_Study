// src/main/java/umc/spring/apiPayload/exception/notfound/MemberMissionNotFoundException.java
package umc.spring.apiPayload.exception.notfound;   // ✅ 패키지

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;

public class MemberMissionNotFoundException extends GeneralException {

    public MemberMissionNotFoundException() {
        super(ErrorStatus.MISSION_CHALLENGE_NOT_FOUND);   // ✅ 그대로 사용
    }

    @Override
    public BaseErrorCode getErrorCode() {
        return ErrorStatus.MISSION_CHALLENGE_NOT_FOUND;
    }
}
