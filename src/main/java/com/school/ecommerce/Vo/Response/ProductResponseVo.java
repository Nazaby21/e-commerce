package com.school.ecommerce.Vo.Response;

import com.school.ecommerce.Enumeration.Status;

public record ProductResponseVo(
        String productName,
        String description,
        Double productPrice,
        Status status) {
}
