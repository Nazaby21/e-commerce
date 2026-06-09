package com.school.ecommerce.Service;

import com.school.ecommerce.Dto.Request.CreateProductRequestDto;
import com.school.ecommerce.Dto.Request.UpdateProductRequestDto;
import com.school.ecommerce.Dto.Response.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(CreateProductRequestDto createProductRequestDto);

    ProductResponseDto updateProduct(Long id, UpdateProductRequestDto updateProductRequestDto);

    ProductResponseDto getProductById(Long id);

    List<ProductResponseDto> getProducts();

    void deleteProductById(Long id);
}