package com.school.ecommerce.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StockResponseVo(
        @JsonProperty("stock_id")
        Long id,
        @JsonProperty("product_id")
        Long productId,
        Integer quantity
) {
}
