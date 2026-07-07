package com.school.ecommerce.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Status;

public record ProductResponseVo(
        Long id,
        @JsonProperty("category_id")
        Long categoryId,
        @JsonProperty("product_name")
        String name,
        String description,
        Integer quantity,
        @JsonProperty("product_price")
        Double price
) {
}
