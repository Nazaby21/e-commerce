package com.school.ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Status;
import com.school.ecommerce.vo.response.OrderItemResponseVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponseDto {
    @JsonProperty("order_id")
    private Long orderId;
    @JsonProperty("total_price")
    private Double totalPrice;
    private Status status;
    private List<OrderItemResponseVo> items;
}
