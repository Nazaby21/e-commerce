package com.school.ecommerce.Vo.Request;

import com.school.ecommerce.Enumeration.Status;

public record CreateProductRequestVo(
        String productName,
        String description,
        Double productPrice,
        Status status
) {
}
