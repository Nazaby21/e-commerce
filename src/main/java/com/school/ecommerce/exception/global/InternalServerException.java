package com.school.ecommerce.exception.global;

import org.springframework.http.HttpStatus;

public class InternalServerException extends GlobalException {

    public InternalServerException(String message) {
        super(message, "ERR_500", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public InternalServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
