package com.school.ecommerce.Service;

import com.school.ecommerce.Dto.Request.RoleRequestDto;
import com.school.ecommerce.Dto.Response.RoleResponseDto;

import java.util.List;

public interface UserRoleService {
    RoleResponseDto createRole(RoleRequestDto roleRequestDto);
    RoleResponseDto getRoleById(Long id);
    List<RoleResponseDto> getAllRoles();
    RoleResponseDto updateRole(Long id, RoleRequestDto roleRequestDto);
}
