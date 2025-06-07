package com.neru.backend.global.response;

import com.neru.backend.global.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ApiResponse<T> {
    private final LocalDateTime timestamp;
    private final boolean success;
    private final int status;
    private final String message;
    private final T data;

    public static <T> ApiResponse<T> success(SuccessCode code, T data) {
        return ApiResponse.<T>builder()
                .timestamp(LocalDateTime.now())
                .success(true)
                .status(code.getStatus().value())
                .message(code.getMessage())
                .data(data)
                .build();
    }

    public static ApiResponse<Void> error(ErrorCode errorCode) {
        return ApiResponse.<Void>builder()
                .timestamp(LocalDateTime.now())
                .success(false)
                .status(errorCode.getStatus().value())
                .message(errorCode.getMessage())
                .data(null)
                .build();
    }
}