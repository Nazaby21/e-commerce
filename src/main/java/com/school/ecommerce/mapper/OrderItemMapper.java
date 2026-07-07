package com.school.ecommerce.mapper;

import com.school.ecommerce.dto.request.CreateOrderItemRequestDto;
import com.school.ecommerce.dto.response.OrderItemResponseDto;
import com.school.ecommerce.model.OrderItem;
import com.school.ecommerce.vo.request.CreateOrderItemRequestVo;
import com.school.ecommerce.vo.response.OrderItemResponseVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    // vo to dto
    CreateOrderItemRequestDto createOrderItemRequestVoToDto(CreateOrderItemRequestVo requestVo);

    // entity to dto
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "unitPrice", target = "price")
    @Mapping(target = "subTotal", expression = "java(orderItem.getUnitPrice() * orderItem.getQuantity())")
    OrderItemResponseDto orderItemEntityToResponseDto(OrderItem orderItem);

    // dto to vo
    OrderItemResponseVo orderResponseDtoToVo(OrderItemResponseDto orderItemResponseDto);
}
