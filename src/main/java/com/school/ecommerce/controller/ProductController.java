package com.school.ecommerce.controller;

import com.school.ecommerce.dto.request.CreateProductRequestDto;
import com.school.ecommerce.dto.request.UpdateProductRequestDto;
import com.school.ecommerce.dto.response.ApiResponse;
import com.school.ecommerce.dto.response.ProductResponseDto;
import com.school.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ApiResponse<ProductResponseDto> createProduct(@Valid @RequestBody CreateProductRequestDto createProductRequestDto) {
        ProductResponseDto product = productService.createProduct(createProductRequestDto);
        return ApiResponse.success(product);
    }

    @PutMapping("/{id}")
    public ApiResponse<ProductResponseDto> updateProduct(@PathVariable Long id, @Valid @RequestBody UpdateProductRequestDto updateProductRequestDto) {
        ProductResponseDto product = productService.updateProduct(id, updateProductRequestDto);
        return ApiResponse.success(product);
    }

    @GetMapping
    public ApiResponse<List<ProductResponseDto>> getProducts() {
        List<ProductResponseDto> products = productService.getProducts();
        return ApiResponse.success(products);
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductResponseDto> getProductById(@PathVariable Long id) {
        ProductResponseDto productById = productService.getProductById(id);
        return ApiResponse.success(productById);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "Product with id: " + id + " has been deleted";
    }
}
