package com.school.ecommerce.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateOrderItemRequestVo(
        @NotNull(message = "product is required.")
        @JsonProperty("product_id")
        Long productId,
        @NotNull(message = "QTY is required.")
        @Min(value = 1, message = "QTY must be greater than 0.")
        Integer quantity
) {
}
