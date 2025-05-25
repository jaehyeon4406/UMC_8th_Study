package umc.spring.apiPayload.exception.notfound;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;

public class MemberNotFoundException extends GeneralException {
    public MemberNotFoundException() { super(ErrorStatus.MEMBER_NOT_FOUND); }
    @Override public BaseErrorCode getErrorCode() { return ErrorStatus.MEMBER_NOT_FOUND; }
}
