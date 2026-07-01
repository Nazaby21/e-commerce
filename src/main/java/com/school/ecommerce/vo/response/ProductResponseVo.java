package com.school.ecommerce.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Status;

public record ProductResponseVo(
        Long id,
        @JsonProperty("user_id")
        Long userId,
        @JsonProperty("category_id")
        Long categoryId,
        @JsonProperty("product_name")
        String productName,
        String description,
        @JsonProperty("product_price")
        Double productPrice,
        Status status) {
}
