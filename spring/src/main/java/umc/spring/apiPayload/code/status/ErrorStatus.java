package umc.spring.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // ── 공통 ─────────────────────────────────────────────
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
    _INVALID_PAGE(HttpStatus.BAD_REQUEST, "COMMON4002", "page 값은 1 이상이어야 합니다."),

    // ── 도메인 Not-Found ────────────────────────────────
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST, "MISSION4001", "존재하지 않는 미션입니다."),
    MISSION_CHALLENGE_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION_CHALLENGE4001", "진행중인 미션이 없습니다."),
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE4001", "해당 가게가 존재하지 않습니다."),
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION4001", "해당 지역이 존재하지 않습니다."),
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "FOOD_CATEGORY4001", "해당 음식 카테고리를 찾을 수 없습니다."),
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .httpStatus(httpStatus)   // 🔹 수정 : status(...) → httpStatus(...)
                .code(code)
                .message(message)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .httpStatus(httpStatus)   // 🔹 수정
                .code(code)
                .message(message)
                .isSuccess(false)
                .build();
    }

}
