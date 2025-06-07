package com.neru.backend.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessCode {
    OK(HttpStatus.OK, "요청이 성공적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED, "리소스가 성공적으로 생성되었습니다."),
    UPDATED(HttpStatus.OK, "리소스가 성공적으로 수정되었습니다."),
    DELETED(HttpStatus.OK, "리소스가 성공적으로 삭제되었습니다.");

    private final HttpStatus status;
    private final String message;

    SuccessCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}