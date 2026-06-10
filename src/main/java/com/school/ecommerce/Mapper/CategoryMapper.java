package com.school.ecommerce.Mapper;

import com.school.ecommerce.Dto.Request.CreateCategoryRequestDto;
import com.school.ecommerce.Dto.Request.UpdateCategoryRequestDto;
import com.school.ecommerce.Dto.Response.CategoryResponseDto;
import com.school.ecommerce.Model.Category;
import com.school.ecommerce.Vo.Request.CreateCategoryRequestVo;
import com.school.ecommerce.Vo.Request.UpdateCategoryRequestVo;
import com.school.ecommerce.Vo.Response.CategoryResponseVo;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // categoryVo to Dto
    CreateCategoryRequestDto createCategoryVoToDto(CreateCategoryRequestVo createCategoryRequestVo);
    UpdateCategoryRequestDto updateCategoryVoToDto(UpdateCategoryRequestVo updateCategoryRequestVo);

    // categoryDto to Entity
    Category categoryDtoToEntity(CreateCategoryRequestDto createCategoryRequestDto);

    // categoryEntity to Dto
    CategoryResponseDto categoryEntityToDto(Category category);

    //categoryDto to Vo
    CategoryResponseVo categoryDtoToVo(CategoryResponseDto categoryResponseDto);

    //updateCategory
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategoryFromDto(UpdateCategoryRequestDto updateCategoryRequestDto, @MappingTarget Category category);
}
