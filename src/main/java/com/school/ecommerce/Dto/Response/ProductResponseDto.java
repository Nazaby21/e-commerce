package com.school.ecommerce.Dto.Response;

import com.school.ecommerce.Enumeration.Status;
import com.school.ecommerce.Model.Category;
import com.school.ecommerce.Model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private Long userId;
    private Long categoryId;
    private String productName;
    private String description;
    private Double productPrice;
    private Status status;
}
