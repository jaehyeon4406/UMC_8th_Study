package umc.spring.apiPayload.exception.notfound;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;

public class RegionNotFoundException extends GeneralException {
    public RegionNotFoundException() { super(ErrorStatus.REGION_NOT_FOUND); }
    @Override public BaseErrorCode getErrorCode() { return ErrorStatus.REGION_NOT_FOUND; }
}
