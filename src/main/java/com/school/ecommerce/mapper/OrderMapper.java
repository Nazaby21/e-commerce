package com.school.ecommerce.mapper;

import com.school.ecommerce.dto.request.CreateOrderRequestDto;
import com.school.ecommerce.dto.response.OrderResponseDto;
import com.school.ecommerce.model.Order;
import com.school.ecommerce.vo.request.CreateOrderRequestVo;
import com.school.ecommerce.vo.response.OrderResponseVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderMapper {

    //vo to dto
    CreateOrderRequestDto createOrderVoToDto(CreateOrderRequestVo requestVo);
    // entity to dto
    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "orderItems", target = "items")
    OrderResponseDto orderEntityToDto(Order order);
    // dto to vo
    OrderResponseVo orderResponseDtoToVo(OrderResponseDto responseDto);
}
