package com.school.ecommerce.service.impl;

import com.school.ecommerce.dto.request.CreateCategoryRequestDto;
import com.school.ecommerce.dto.request.UpdateCategoryRequestDto;
import com.school.ecommerce.dto.response.CategoryResponseDto;
import com.school.ecommerce.exception.Custom.ResourceAlreadyExistsException;
import com.school.ecommerce.exception.Custom.ResourceNotFoundException;
import com.school.ecommerce.mapper.CategoryMapper;
import com.school.ecommerce.model.Category;
import com.school.ecommerce.repository.CategoryRepository;
import com.school.ecommerce.service.CategoryService;
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
        log.info("createCategory : ${createCategoryRequestDto.getCategoryName()}");
        if (categoryRepository.existsByName(createCategoryRequestDto.getCategoryName())) {
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
                && categoryRepository.existsByName(categoryName)) {

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
