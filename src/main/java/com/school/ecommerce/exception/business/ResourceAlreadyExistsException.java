package com.school.ecommerce.exception.business;

public class ResourceAlreadyExistsException extends DuplicateResourceException {

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }

    public static ResourceAlreadyExistsException byField(String resourceName, String fieldName, Object value) {
        return new ResourceAlreadyExistsException(String.format("%s with %s '%s' already exists", resourceName, fieldName, value));
    }

    public static ResourceAlreadyExistsException byName(String resourceName, String fieldName, Object value) {
        return new ResourceAlreadyExistsException(String.format("%s with %s '%s' already exists", resourceName, fieldName, value));
    }
}
