package com.school.ecommerce.mapper;

import com.school.ecommerce.dto.response.OrderResponseDto;
import com.school.ecommerce.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderMapper {

    // entity to dto
    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "orderItems", target = "items")
    OrderResponseDto orderEntityToDto(Order order);
}
