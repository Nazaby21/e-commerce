package com.school.ecommerce.Service.Impl;

import com.school.ecommerce.Dto.Request.CreateCategoryRequestDto;
import com.school.ecommerce.Dto.Request.UpdateCategoryRequestDto;
import com.school.ecommerce.Dto.Response.CategoryResponseDto;
import com.school.ecommerce.Exception.Custom.ResourceAlreadyExistsException;
import com.school.ecommerce.Exception.Custom.ResourceNotFoundException;
import com.school.ecommerce.Mapper.CategoryMapper;
import com.school.ecommerce.Model.Category;
import com.school.ecommerce.Repository.CategoryRepository;
import com.school.ecommerce.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDto createCategory(CreateCategoryRequestDto createCategoryRequestDto) {
        if (categoryRepository.existsByCategoryName(createCategoryRequestDto.getCategoryName())) {
            throw ResourceAlreadyExistsException.byField("Category", "name", createCategoryRequestDto.getCategoryName());
        }
        Category category = categoryMapper.categoryDtoToEntity(createCategoryRequestDto);
        Category saveCategory = categoryRepository.save(category);
        return categoryMapper.categoryEntityToDto(saveCategory);
    }

    @Override
    public CategoryResponseDto getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.byId("Category", id));
        return categoryMapper.categoryEntityToDto(category);
    }

    @Override
    public List<CategoryResponseDto> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryEntityToDto)
                .toList();
    }

    @Override
    public CategoryResponseDto updateCategory(
            Long id,
            UpdateCategoryRequestDto updateCategoryRequestDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.byId("Category", id));

        String categoryName = updateCategoryRequestDto.getCategoryName();
        if (categoryName != null
                && categoryRepository.existsByCategoryName(categoryName)) {

            throw ResourceAlreadyExistsException.byField(
                    "Category",
                    "name",
                    categoryName);
        }

        categoryMapper.updateCategoryFromDto(
                updateCategoryRequestDto,
                category);

        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.categoryEntityToDto(savedCategory);
    }
}
