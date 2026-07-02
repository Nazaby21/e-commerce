package com.school.ecommerce.mapper;

import com.school.ecommerce.dto.request.CreateOrderRequestDto;
import com.school.ecommerce.dto.response.OrderResponseDto;
import com.school.ecommerce.model.Order;
import com.school.ecommerce.vo.request.CreateOrderRequestVo;
import com.school.ecommerce.vo.response.OrderResponseVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    //vo to dto
    CreateOrderRequestDto createOrderVoToDto(CreateOrderRequestVo vo);

    // dto to entity
    Order createOrder(CreateOrderRequestDto dto);

    // entity to dto
    OrderResponseDto orderEntityToDto(Order order);

    // dto to vo
    OrderResponseVo createOrderResponseVoToDto(OrderResponseVo vo);
}
