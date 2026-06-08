package com.school.ecommerce.Mapper;

import com.school.ecommerce.Dto.Request.RoleRequestDto;
import com.school.ecommerce.Dto.Response.RoleResponseDto;
import com.school.ecommerce.Model.UserRole;
import com.school.ecommerce.Vo.Request.RoleRequestVo;
import com.school.ecommerce.Vo.Response.RoleResponseVo;
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
