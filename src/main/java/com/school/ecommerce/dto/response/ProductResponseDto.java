package com.school.ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    @JsonProperty("category_id")
    private Long categoryId;
    @JsonProperty("product_name")
    private String name;
    private String description;
    private Integer quantity;
    @JsonProperty("product_price")
    private Double price;
}
