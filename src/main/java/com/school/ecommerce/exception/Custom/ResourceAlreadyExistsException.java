package com.school.ecommerce.exception.Custom;

import com.school.ecommerce.exception.Constants.ErrorMessage;
import lombok.Getter;

@Getter
public class ResourceAlreadyExistsException extends RuntimeException{
    private final ErrorMessage errorMessage;
    public ResourceAlreadyExistsException(String message) {
        super(message);
        this.errorMessage = ErrorMessage.RESOURCE_ALREADY_EXISTS;
    }

    public static ResourceAlreadyExistsException byField(String resourceName, String email, Object value )
    {
        return new ResourceAlreadyExistsException(
                String.format(
                        ErrorMessage.RESOURCE_ALREADY_EXISTS.getMessage(),
                        resourceName,
                        email,
                        value
                )
        );
    }

    public static ResourceAlreadyExistsException byName(String resourceName, String productName, Object value )
    {
        return new ResourceAlreadyExistsException(
                String.format(
                        ErrorMessage.RESOURCE_ALREADY_EXISTS.getMessage(),
                        resourceName,
                        productName,
                        value
                )
        );
    }
}
