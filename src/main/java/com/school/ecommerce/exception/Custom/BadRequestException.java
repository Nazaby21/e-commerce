package com.school.ecommerce.exception.Custom;

import com.school.ecommerce.exception.Constants.ErrorMessage;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {
    private final ErrorMessage errorMessage;
    public BadRequestException(String message) {
        super(message);
        this.errorMessage = ErrorMessage.INVALID_GENDER;
    }

    public static BadRequestException gender()
    {
        return new BadRequestException(
                String.format(
                        ErrorMessage.RESOURCE_ALREADY_EXISTS.getMessage()
                )
        );
    }
}
