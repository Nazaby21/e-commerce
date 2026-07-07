package com.school.ecommerce.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateOrderRequestVo(
        @NotNull
        @JsonProperty("buyer_id")
        Long buyerId,
        @NotEmpty(message = "Order must contain at least one item.")
        List<CreateOrderItemRequestVo> items
) {
}
