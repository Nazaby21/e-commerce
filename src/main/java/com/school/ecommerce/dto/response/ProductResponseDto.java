package com.school.ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("category_id")
    private Long categoryId;
    @JsonProperty("product_name")
    private String productName;
    private String description;
    @JsonProperty("product_price")
    private Double productPrice;
    private Status status;
}
