package com.school.ecommerce.controller;

import com.school.ecommerce.dto.request.CreateCategoryRequestDto;
import com.school.ecommerce.dto.request.UpdateCategoryRequestDto;
import com.school.ecommerce.dto.response.ApiResponse;
import com.school.ecommerce.dto.response.CategoryResponseDto;
import com.school.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ApiResponse<CategoryResponseDto> createCategory(@Valid @RequestBody CreateCategoryRequestDto createCategoryRequestDto) {
        CategoryResponseDto category = categoryService.createCategory(createCategoryRequestDto);
        return ApiResponse.success(category);
    }

    @GetMapping
    public ApiResponse<List<CategoryResponseDto>> getAllCategories() {
        List<CategoryResponseDto> categories = categoryService.getCategories();
        return ApiResponse.success(categories);
    }

    @GetMapping("/{id}")
    public ApiResponse<CategoryResponseDto> getCategoryById(@PathVariable Long id) {
        CategoryResponseDto category = categoryService.getById(id);
        return ApiResponse.success(category);
    }

    @PutMapping("/{id}")
    public ApiResponse<CategoryResponseDto> updateCategory(@PathVariable Long id, @Valid @RequestBody UpdateCategoryRequestDto updateCategoryRequestDto) {
        CategoryResponseDto categoryResponseDto = categoryService.updateCategory(id, updateCategoryRequestDto);
        return ApiResponse.success(categoryResponseDto);
    }
}
