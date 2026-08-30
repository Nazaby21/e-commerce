package com.school.ecommerce.mapper;

import com.school.ecommerce.dto.response.OrderItemResponseDto;
import com.school.ecommerce.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    // entity to dto
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "unitPrice", target = "price")
    @Mapping(target = "subTotal", expression = "java(orderItem.getUnitPrice() * orderItem.getQuantity())")
    OrderItemResponseDto orderItemEntityToResponseDto(OrderItem orderItem);
}
