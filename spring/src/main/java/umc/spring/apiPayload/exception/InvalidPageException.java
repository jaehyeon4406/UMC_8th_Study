package umc.spring.apiPayload.exception;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.status.ErrorStatus;

public class InvalidPageException extends GeneralException {
    public InvalidPageException() {
        super(ErrorStatus._INVALID_PAGE);
    }
    @Override
    public BaseErrorCode getErrorCode() { return ErrorStatus._INVALID_PAGE; }
}
