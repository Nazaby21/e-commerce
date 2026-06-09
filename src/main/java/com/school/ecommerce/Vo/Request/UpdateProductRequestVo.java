package com.school.ecommerce.Vo.Request;


public record UpdateProductRequestVo(
        String productName,
        String description,
        Double productPrice
) {
}
