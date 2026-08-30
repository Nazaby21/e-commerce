package com.school.ecommerce;

import com.school.ecommerce.controller.CategoryController;
import com.school.ecommerce.dto.request.CreateCategoryRequestDto;
import com.school.ecommerce.dto.response.ApiResponse;
import com.school.ecommerce.dto.response.CategoryResponseDto;
import com.school.ecommerce.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    private CategoryResponseDto categoryResponseDto;

    @BeforeEach
    void setUp() {
        categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(1L);
        categoryResponseDto.setCategoryName("Books");
        categoryResponseDto.setDescription("Book collection");
    }

    @Test
    void createCategory_Success() {
        CreateCategoryRequestDto requestDto = new CreateCategoryRequestDto();
        requestDto.setCategoryName("Books");
        requestDto.setDescription("Book collection");

        when(categoryService.createCategory(any(CreateCategoryRequestDto.class))).thenReturn(categoryResponseDto);

        ApiResponse<CategoryResponseDto> response = categoryController.createCategory(requestDto);

        assertNotNull(response);
        assertEquals("200", response.getCode());
        assertEquals("Success", response.getMessage());
        assertEquals("Books", response.getData().getCategoryName());
    }

    @Test
    void getAllCategories_Success() {
        when(categoryService.getCategories()).thenReturn(List.of(categoryResponseDto));

        ApiResponse<List<CategoryResponseDto>> response = categoryController.getAllCategories();

        assertNotNull(response);
        assertEquals(1, response.getData().size());
        assertEquals("Books", response.getData().get(0).getCategoryName());
    }

    @Test
    void getCategoryById_Success() {
        when(categoryService.getById(1L)).thenReturn(categoryResponseDto);

        ApiResponse<CategoryResponseDto> response = categoryController.getCategoryById(1L);

        assertNotNull(response);
        assertEquals(1L, response.getData().getId());
        assertEquals("Books", response.getData().getCategoryName());
    }
}
