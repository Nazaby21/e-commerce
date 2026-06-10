package com.school.ecommerce.Exception.Custom;

import com.school.ecommerce.Exception.Constants.ErrorMessage;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final ErrorMessage errorMessage;
    public ResourceNotFoundException(String message) {
        super(message);
        this.errorMessage = ErrorMessage.RESOURCE_NOT_FOUND;
    }

    public static ResourceNotFoundException byId(String resourceName, Object id) {
        return new ResourceNotFoundException(
                String.format(
                        ErrorMessage.RESOURCE_NOT_FOUND.getMessage(),
                        resourceName,
                        id
                )
        );
    }
}
