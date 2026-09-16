package com.daya.weekendsoffbackend.exception;

import com.daya.weekendsoffbackend.common.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public Result<Object> handleBusinessException(BusinessException e) {
        return Result.fail(
                e.getCode(),
                e.getMessage()
        );
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public Result<Object> handleValidationException(handleValidationException e) {
        String message=e.getBindingResult().getFieldError().getDefaultMessage();
        return Result.fail(400, message);
    }

    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(Exception e) {
        return Result.fail(500, "服务器错误");
    }
}
