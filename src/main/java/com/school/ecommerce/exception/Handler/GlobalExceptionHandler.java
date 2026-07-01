package com.school.ecommerce.exception.Handler;

import com.school.ecommerce.exception.Constants.ErrorMessage;
import com.school.ecommerce.exception.Custom.ResourceAlreadyExistsException;
import com.school.ecommerce.exception.Custom.ResourceNotFoundException;
import com.school.ecommerce.exception.Dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.xml.bind.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex, HttpServletRequest httpServletRequest) {
        ErrorMessage errorMessage = ex.getErrorMessage();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(errorMessage.getErrorCode())
                .message(ex.getMessage())
                .status(errorMessage.getStatus().value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity
                .status(errorMessage.getStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExists(ResourceAlreadyExistsException ex, HttpServletRequest httpServletRequest) {
        ErrorMessage errorMessage = ex.getErrorMessage();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(errorMessage.getErrorCode())
                .message(ex.getMessage())
                .status(errorMessage.getStatus().value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity
                .status(errorMessage.getStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception ex, HttpServletRequest httpServletRequest) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(ErrorMessage.INTERNAL_ERROR.getErrorCode())
                .message(ErrorMessage.INTERNAL_ERROR.getMessage())
                .status(ErrorMessage.INTERNAL_ERROR.getStatus().value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity
                .status(ErrorMessage.INTERNAL_ERROR.getStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex, HttpServletRequest httpServletRequest) {
        ErrorResponse errorResponse = ErrorResponse.builder().message(
                ex.getMessage()
        ).status(500).timestamp(LocalDateTime.now()).build();

return ResponseEntity
                .status(errorResponse.getStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            ValidationException ex,
            HttpServletRequest httpServletRequest) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(ErrorMessage.VALIDATION_ERROR.getErrorCode())
                .message(ex.getMessage())
                .status(ErrorMessage.VALIDATION_ERROR.getStatus().value())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(ErrorMessage.VALIDATION_ERROR.getStatus())
                .body(errorResponse);
    }
}