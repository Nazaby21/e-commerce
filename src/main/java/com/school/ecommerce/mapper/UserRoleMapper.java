package com.school.ecommerce.mapper;

import com.school.ecommerce.dto.request.RoleRequestDto;
import com.school.ecommerce.dto.response.RoleResponseDto;
import com.school.ecommerce.model.UserRole;
import com.school.ecommerce.vo.request.RoleRequestVo;
import com.school.ecommerce.vo.response.RoleResponseVo;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    // roleVo to Dto
    RoleRequestDto roleVoToDto(RoleRequestVo roleRequestVo);

    // roleDto to Entity
    UserRole roleDtoToEntity(RoleRequestDto roleRequestDto);

    // roleDto to Vo
    RoleResponseVo roleDtoToVo(RoleResponseDto roleResponseDto);

    // roleEntity toDto
    RoleResponseDto roleEntityToDto(UserRole role);

    // updateRole
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateRoleUserFromDto(RoleRequestDto roleRequestDto, @MappingTarget UserRole userRole);
}
