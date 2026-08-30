package com.school.ecommerce;

import com.school.ecommerce.dto.request.CreateCategoryRequestDto;
import com.school.ecommerce.exception.business.BusinessException;
import com.school.ecommerce.exception.business.DuplicateResourceException;
import com.school.ecommerce.exception.business.InsufficientStockException;
import com.school.ecommerce.exception.business.ResourceNotFoundException;
import com.school.ecommerce.exception.global.ErrorResponse;
import com.school.ecommerce.exception.global.GlobalExceptionHandler;
import com.school.ecommerce.exception.validation.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler exceptionHandler;
    private MockHttpServletRequest request;

    @BeforeEach
    void setUp() {
        exceptionHandler = new GlobalExceptionHandler();
        request = new MockHttpServletRequest();
        request.setRequestURI("/api/v1/test");
    }

    @Test
    void handleResourceNotFoundException() {
        ResourceNotFoundException ex = ResourceNotFoundException.byId("Category", 99L);
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleBusinessException(ex, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("ERR_404", response.getBody().getCode());
        assertEquals("Category with id 99 not found", response.getBody().getMessage());
        assertEquals(404, response.getBody().getStatus());
        assertEquals("/api/v1/test", response.getBody().getPath());
    }

    @Test
    void handleDuplicateResourceException() {
        DuplicateResourceException ex = DuplicateResourceException.byField("Category", "name", "Electronics");
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleBusinessException(ex, request);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("ERR_409", response.getBody().getCode());
        assertEquals("Category with name 'Electronics' already exists", response.getBody().getMessage());
    }

    @Test
    void handleInsufficientStockException() {
        InsufficientStockException ex = InsufficientStockException.forProduct(10L);
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleBusinessException(ex, request);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("ERR_400", response.getBody().getCode());
        assertEquals("Insufficient stock for product id: 10", response.getBody().getMessage());
    }

    @Test
    void handleValidationException() {
        ValidationException ex = new ValidationException("Invalid payload");
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleValidationException(ex, request);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("VALIDATION_ERROR", response.getBody().getCode());
        assertEquals("Invalid payload", response.getBody().getMessage());
    }

    @Test
    void handleMethodArgumentNotValid() throws NoSuchMethodException {
        CreateCategoryRequestDto target = new CreateCategoryRequestDto();
        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(target, "createCategoryRequestDto");
        bindingResult.addError(new FieldError("createCategoryRequestDto", "categoryName", "categoryname is required"));

        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, bindingResult);
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleMethodArgumentNotValid(ex, request);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("VALIDATION_ERROR", response.getBody().getCode());
        assertEquals("categoryname is required", response.getBody().getMessage());
        assertNotNull(response.getBody().getErrors());
        assertEquals(1, response.getBody().getErrors().size());
        assertEquals("categoryName", response.getBody().getErrors().get(0).getField());
    }

    @Test
    void handleUnhandledException() {
        Exception ex = new RuntimeException("DB connection failure");
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleUnhandledException(ex, request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("INTERNAL_ERROR", response.getBody().getCode());
        assertEquals("An unexpected error occurred. Please try again later.", response.getBody().getMessage());
    }
}
