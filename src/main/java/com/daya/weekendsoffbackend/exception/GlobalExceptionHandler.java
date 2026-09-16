package com.daya.weekendsoffbackend.exception;

import com.daya.weekendsoffbackend.common.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Result<Void>> handleBusinessException(BusinessException e) {
        Integer code = e.getCode();
        HttpStatus status = code != null ? HttpStatus.resolve(code) : null;
        if (status == null) {
            status = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(status)
                .body(new Result<>(code != null ? code : status.value(), e.getMessage(), null));
    }
}
