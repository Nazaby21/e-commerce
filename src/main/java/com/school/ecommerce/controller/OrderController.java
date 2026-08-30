package com.school.ecommerce.controller;

import com.school.ecommerce.dto.request.CreateOrderRequestDto;
import com.school.ecommerce.dto.response.ApiResponse;
import com.school.ecommerce.dto.response.OrderResponseDto;
import com.school.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ApiResponse<OrderResponseDto> createOrder(@Valid @RequestBody CreateOrderRequestDto createOrderRequestDto) {
        OrderResponseDto order = orderService.createOrder(createOrderRequestDto);
        return ApiResponse.success(order);
    }
}
