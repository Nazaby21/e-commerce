package com.school.ecommerce.exception.business;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends BusinessException {

    public UnauthorizedException(String message) {
        super(message, "ERR_401", HttpStatus.UNAUTHORIZED);
    }
}
