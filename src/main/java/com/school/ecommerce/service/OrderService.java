package com.school.ecommerce.service;

import com.school.ecommerce.dto.request.CreateOrderRequestDto;
import com.school.ecommerce.dto.response.OrderResponseDto;

public interface OrderService {
    OrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto);
}
