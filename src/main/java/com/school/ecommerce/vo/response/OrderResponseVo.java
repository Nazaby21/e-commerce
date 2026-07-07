package com.school.ecommerce.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Status;

import java.util.List;

public record OrderResponseVo(
        @JsonProperty("order_id")
        Long orderId,
        @JsonProperty("total_price")
        Double totalPrice,
        Status status,
        List<OrderItemResponseVo> items
) {
}
