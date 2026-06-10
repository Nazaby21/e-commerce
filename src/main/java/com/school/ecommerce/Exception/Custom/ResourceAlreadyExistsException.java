package com.school.ecommerce.Exception.Custom;

import com.school.ecommerce.Exception.Constants.ErrorMessage;
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
}
