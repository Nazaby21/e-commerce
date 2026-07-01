package com.school.ecommerce.service;

import com.school.ecommerce.dto.request.CreateCategoryRequestDto;
import com.school.ecommerce.dto.request.UpdateCategoryRequestDto;
import com.school.ecommerce.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto createCategory(CreateCategoryRequestDto createCategoryRequestDto);
    CategoryResponseDto getById(Long id);;
    List<CategoryResponseDto> getCategories();
    CategoryResponseDto updateCategory(Long id, UpdateCategoryRequestDto updateCategoryRequestDto);
}
