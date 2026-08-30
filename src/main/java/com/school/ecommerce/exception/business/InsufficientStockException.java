package com.school.ecommerce.exception.business;

import org.springframework.http.HttpStatus;

public class InsufficientStockException extends BusinessException {

    public InsufficientStockException(String message) {
        super(message, "ERR_400", HttpStatus.BAD_REQUEST);
    }

    public static InsufficientStockException forProduct(Long productId) {
        return new InsufficientStockException("Insufficient stock for product id: " + productId);
    }
}
