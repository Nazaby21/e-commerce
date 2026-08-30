package com.school.ecommerce.exception.global;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GlobalException extends RuntimeException {
    private final HttpStatus status;
    private final String errorCode;

    public GlobalException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.errorCode = "ERR_500";
    }

    public GlobalException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.errorCode = "ERR_" + status.value();
    }

    public GlobalException(String message, String errorCode, HttpStatus status) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.errorCode = "ERR_500";
    }
}
