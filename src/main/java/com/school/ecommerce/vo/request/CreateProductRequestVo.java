package com.school.ecommerce.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Status;

public record CreateProductRequestVo(
        @JsonProperty("user_id")
        Long userId,
        @JsonProperty("category_id")
        Long categoryId,
        @JsonProperty("product_name")
        String productName,
        String description,
        @JsonProperty("product_price")
        Double productPrice,
        Status status
) {
}
