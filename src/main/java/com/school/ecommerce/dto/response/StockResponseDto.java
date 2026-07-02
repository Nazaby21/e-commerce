package com.school.ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockResponseDto {
    @JsonProperty("stock_id")
    private Long id;
    @JsonProperty("product_id")
    private Long productId;
    private Integer quantity;
}
