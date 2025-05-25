package umc.spring.apiPayload.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.apiPayload.code.ErrorReasonDTO;
import umc.spring.apiPayload.code.status.ErrorStatus;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 전역 예외 처리기 – 모든 컨트롤러 예외를 ApiResponse 래퍼로 변환
 */
@Slf4j
@RestControllerAdvice(annotations = {RestController.class})
public class ExceptionAdvice {

    /* ───────────────────────── 1) 커스텀 예외 ───────────────────────── */
    @ExceptionHandler(GeneralException.class)
    public ApiResponse<ErrorReasonDTO> handleGeneral(GeneralException ex) {
        ErrorReasonDTO reason = ex.getErrorReason();
        return ApiResponse.onFailure(reason.getCode(), reason.getMessage(), reason);
    }

    /* ───────────────────────── 2) 제약 조건 위반 ───────────────────── */
    @ExceptionHandler(ConstraintViolationException.class)
    public ApiResponse<ErrorReasonDTO> handleConstraint(ConstraintViolationException ex) {
        String key = ex.getConstraintViolations().stream()
                .map(v -> v.getMessage())      // 메시지 = ErrorStatus 상수명
                .findFirst()
                .orElse(ErrorStatus._BAD_REQUEST.name());

        ErrorReasonDTO reason = ErrorStatus.valueOf(key).getReason();
        return ApiResponse.onFailure(reason.getCode(), reason.getMessage(), reason);
    }

    /* ───────────────────────── 3) DTO @Valid 실패 ──────────────────── */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Map<String, String>> handleMethodArgument(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new LinkedHashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(fe -> {
            String field   = fe.getField();
            String message = Optional.ofNullable(fe.getDefaultMessage()).orElse("");
            errors.merge(field, message, (oldMsg, newMsg) -> oldMsg + ", " + newMsg);
        });

        return ApiResponse.onFailure(ErrorStatus._BAD_REQUEST.getCode(),
                "Validation failed", errors);
    }

    /* ───────────────────────── 4) 예상 못 한 모든 예외 ─────────────── */
    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleEtc(Exception ex) {
        log.error("[Unhandled] {}", ex.getMessage(), ex);
        ErrorReasonDTO reason = ErrorStatus._INTERNAL_SERVER_ERROR.getReason();
        return ApiResponse.onFailure(reason.getCode(), reason.getMessage(), null);
    }
}
