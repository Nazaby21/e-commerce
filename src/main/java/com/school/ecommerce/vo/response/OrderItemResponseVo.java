package com.school.ecommerce.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderItemResponseVo(
        @JsonProperty("product_id")
        Long productId,
        @JsonProperty("product_name")
        String productName,
        Integer quantity,
        Double price,
        @JsonProperty("sub_total")
        Double subTotal
) {
}
