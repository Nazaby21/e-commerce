package com.school.ecommerce.controller;

import com.school.ecommerce.dto.request.CreateOrderRequestDto;
import com.school.ecommerce.dto.response.OrderResponseDto;
import com.school.ecommerce.exception.Dto.ApiResponse;
import com.school.ecommerce.mapper.OrderMapper;
import com.school.ecommerce.service.OrderService;
import com.school.ecommerce.vo.request.CreateOrderRequestVo;
import com.school.ecommerce.vo.response.OrderResponseVo;
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
    private final OrderMapper orderMapper;

    @PostMapping
    public ApiResponse<OrderResponseVo> createOrder(@Valid @RequestBody CreateOrderRequestVo createOrderRequestVo) {
        CreateOrderRequestDto orderVoToDto = orderMapper.createOrderVoToDto(createOrderRequestVo);
        OrderResponseDto order = orderService.createOrder(orderVoToDto);
        OrderResponseVo orderResponseVo = orderMapper.orderResponseDtoToVo(order);
        return ApiResponse.success(orderResponseVo);


    }
}
