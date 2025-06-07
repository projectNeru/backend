package com.neru.backend.global.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String, Object>> handleCustomException(CustomException ex) {
        ErrorCode errorCode = ex.getErrorCode();

        Map<String, Object> body = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", errorCode.getStatus().value(),
                "error", errorCode.getStatus().getReasonPhrase(),
                "message", errorCode.getMessage()
        );

        return ResponseEntity.status(errorCode.getStatus()).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> body = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", 500,
                "error", "Internal Server Error",
                "message", ex.getMessage()
        );

        return ResponseEntity.status(500).body(body);
    }
}