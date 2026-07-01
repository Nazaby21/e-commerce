package com.school.ecommerce.service;

import com.school.ecommerce.dto.request.CreateProductRequestDto;
import com.school.ecommerce.dto.request.UpdateProductRequestDto;
import com.school.ecommerce.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(CreateProductRequestDto createProductRequestDto);

    ProductResponseDto updateProduct(Long id, UpdateProductRequestDto updateProductRequestDto);

    ProductResponseDto getProductById(Long id);

    List<ProductResponseDto> getProducts();

    void deleteProductById(Long id);
}