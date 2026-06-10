package com.school.ecommerce.Vo.Response;

import com.school.ecommerce.Enumeration.Status;

public record ProductResponseVo(
        Long id,
        Long userId,
        Long categoryId,
        String productName,
        String description,
        Double productPrice,
        Status status) {
}
