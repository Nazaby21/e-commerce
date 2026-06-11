package com.school.ecommerce.Vo.Request;

import com.school.ecommerce.Enumeration.Status;

public record CreateProductRequestVo(
        Long userId,
        Long categoryId,
        String productName,
        String description,
        Double productPrice,
        Status status
) {
}
