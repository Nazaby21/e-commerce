package com.school.ecommerce.Dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequestDto {
    private String productName;
    private String description;
    private Double productPrice;
}
