package com.school.ecommerce.exception.business;

import org.springframework.http.HttpStatus;

public class DuplicateResourceException extends BusinessException {

    public DuplicateResourceException(String message) {
        super(message, "ERR_409", HttpStatus.CONFLICT);
    }

    public static DuplicateResourceException byField(String resourceName, String fieldName, Object value) {
        return new DuplicateResourceException(String.format("%s with %s '%s' already exists", resourceName, fieldName, value));
    }

    public static DuplicateResourceException byName(String resourceName, String fieldName, Object value) {
        return new DuplicateResourceException(String.format("%s with %s '%s' already exists", resourceName, fieldName, value));
    }
}
