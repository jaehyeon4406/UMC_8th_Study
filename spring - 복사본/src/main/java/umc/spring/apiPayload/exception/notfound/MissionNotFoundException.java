package umc.spring.apiPayload.exception.notfound;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;

public class MissionNotFoundException extends GeneralException {
    public MissionNotFoundException() { super(ErrorStatus.MISSION_NOT_FOUND); }
    @Override public BaseErrorCode getErrorCode() { return ErrorStatus.MISSION_NOT_FOUND; }
}
