package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequestDto {
    @JsonProperty("product_name")
    private String name;
    private String description;
    @JsonProperty("product_price")
    private Double price;
}
