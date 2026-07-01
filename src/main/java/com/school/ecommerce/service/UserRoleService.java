package com.school.ecommerce.service;

import com.school.ecommerce.dto.request.RoleRequestDto;
import com.school.ecommerce.dto.response.RoleResponseDto;

import java.util.List;

public interface UserRoleService {
    RoleResponseDto createRole(RoleRequestDto roleRequestDto);
    RoleResponseDto getRoleById(Long id);
    List<RoleResponseDto> getAllRoles();
    RoleResponseDto updateRole(Long id, RoleRequestDto roleRequestDto);
}
