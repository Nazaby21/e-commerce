package com.school.ecommerce.vo.request;


import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateProductRequestVo(
        @JsonProperty("product_name")
        String productName,
        String description,
        @JsonProperty("product_price")
        Double productPrice
) {
}
