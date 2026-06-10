package com.school.ecommerce.Controller;

import com.school.ecommerce.Dto.Request.CreateCategoryRequestDto;
import com.school.ecommerce.Dto.Request.UpdateCategoryRequestDto;
import com.school.ecommerce.Dto.Response.CategoryResponseDto;
import com.school.ecommerce.Exception.Dto.ApiResponse;
import com.school.ecommerce.Mapper.CategoryMapper;
import com.school.ecommerce.Service.CategoryService;
import com.school.ecommerce.Vo.Request.CreateCategoryRequestVo;
import com.school.ecommerce.Vo.Request.UpdateCategoryRequestVo;
import com.school.ecommerce.Vo.Response.CategoryResponseVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @PostMapping
    public ApiResponse<CategoryResponseVo> createCategory(@Valid @RequestBody CreateCategoryRequestVo createCategoryRequestVo) {
        CreateCategoryRequestDto createCategoryRequestDto = categoryMapper.createCategoryVoToDto(createCategoryRequestVo);
        CategoryResponseDto category = categoryService.createCategory(createCategoryRequestDto);
        CategoryResponseVo categoryResponseVo = categoryMapper.categoryDtoToVo(category);
        return ApiResponse.success(categoryResponseVo);
    }

    @GetMapping
    public ApiResponse<List<CategoryResponseVo>> getAllCategories() {
        List<CategoryResponseVo> categoryResponseVo = categoryService.getCategories()
                .stream()
                .map(categoryMapper::categoryDtoToVo)
                .toList();
        return ApiResponse.success(categoryResponseVo);
    }

    @GetMapping("/{id}")
    public ApiResponse<CategoryResponseVo> getCategoryById(@PathVariable Long id) {
        CategoryResponseVo categoryResponseVo = categoryMapper.categoryDtoToVo(categoryService.getById(id));
        return ApiResponse.success(categoryResponseVo);
    }

    @PutMapping("/{id}")
    public ApiResponse<CategoryResponseVo> updateCategory(@PathVariable Long id, @Valid @RequestBody UpdateCategoryRequestVo updateCategoryRequestVo) {
        UpdateCategoryRequestDto updateCategoryRequestDto = categoryMapper.updateCategoryVoToDto(updateCategoryRequestVo);
        CategoryResponseDto categoryResponseDto = categoryService.updateCategory(id, updateCategoryRequestDto);
        CategoryResponseVo categoryResponseVo = categoryMapper.categoryDtoToVo(categoryResponseDto);
        return ApiResponse.success(categoryResponseVo);
    }
}
