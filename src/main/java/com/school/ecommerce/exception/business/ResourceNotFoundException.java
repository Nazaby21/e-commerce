package com.school.ecommerce.exception.business;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BusinessException {

    public ResourceNotFoundException(String message) {
        super(message, "ERR_404", HttpStatus.NOT_FOUND);
    }

    public static ResourceNotFoundException byId(String resourceName, Object id) {
        return new ResourceNotFoundException(String.format("%s with id %s not found", resourceName, id));
    }

    public static ResourceNotFoundException byField(String resourceName, String fieldName, Object value) {
        return new ResourceNotFoundException(String.format("%s with %s '%s' not found", resourceName, fieldName, value));
    }
}
