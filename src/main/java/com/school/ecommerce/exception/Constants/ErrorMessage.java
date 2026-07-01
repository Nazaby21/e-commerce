package com.school.ecommerce.exception.Constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    SUCCESS("SUCCESS", "Success", HttpStatus.OK),
    RESOURCE_NOT_FOUND("ERR_404", "%s with id %s not found", HttpStatus.NOT_FOUND),
    RESOURCE_ALREADY_EXISTS("ERR_409", "%s with %s '%s' already exists", HttpStatus.CONFLICT),
    INTERNAL_ERROR("ERR_500","Internal Error", HttpStatus.INTERNAL_SERVER_ERROR),
    VALIDATION_ERROR("ERR_500","Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String errorCode;
    private final String message;
    private final HttpStatus status;
}
