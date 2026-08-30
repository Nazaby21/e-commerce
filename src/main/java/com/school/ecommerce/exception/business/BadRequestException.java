package com.school.ecommerce.exception.business;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BusinessException {

    public BadRequestException(String message) {
        super(message, "ERR_400", HttpStatus.BAD_REQUEST);
    }

    public static BadRequestException invalidGender() {
        return new BadRequestException("Gender must be MALE or FEMALE");
    }
}
