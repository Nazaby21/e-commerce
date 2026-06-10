package com.school.ecommerce.Service;

import com.school.ecommerce.Dto.Request.CreateCategoryRequestDto;
import com.school.ecommerce.Dto.Request.UpdateCategoryRequestDto;
import com.school.ecommerce.Dto.Response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto createCategory(CreateCategoryRequestDto createCategoryRequestDto);
    CategoryResponseDto getById(Long id);;
    List<CategoryResponseDto> getCategories();
    CategoryResponseDto updateCategory(Long id, UpdateCategoryRequestDto updateCategoryRequestDto);
}
