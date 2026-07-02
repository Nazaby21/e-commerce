package com.school.ecommerce.service.impl;

import com.school.ecommerce.dto.request.CreateOrderRequestDto;
import com.school.ecommerce.dto.response.OrderResponseDto;
import com.school.ecommerce.mapper.OrderMapper;
import com.school.ecommerce.repository.OrderItemRepository;
import com.school.ecommerce.repository.OrderRepository;
import com.school.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto) {

    }
}
