package com.school.ecommerce.Dto.Response;

import com.school.ecommerce.Enumeration.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private String productName;
    private String description;
    private Double productPrice;
    private Status status;
}
