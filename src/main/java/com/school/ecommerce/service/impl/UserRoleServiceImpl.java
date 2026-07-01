package com.school.ecommerce.service.impl;

import com.school.ecommerce.dto.request.RoleRequestDto;
import com.school.ecommerce.dto.response.RoleResponseDto;
import com.school.ecommerce.exception.Custom.ResourceNotFoundException;
import com.school.ecommerce.mapper.UserRoleMapper;
import com.school.ecommerce.model.UserRole;
import com.school.ecommerce.repository.UserRoleRepository;
import com.school.ecommerce.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final UserRoleMapper userRoleMapper;
    @Override
    public RoleResponseDto createRole(RoleRequestDto roleRequestDto) {
        if (userRoleRepository.existsByRoleName(roleRequestDto.getRoleName())) {
            throw new ResourceNotFoundException("gsds");
        }
        UserRole userRole = userRoleMapper.roleDtoToEntity(roleRequestDto);
        UserRole savedUserRole = userRoleRepository.save(userRole);
        return userRoleMapper.roleEntityToDto(savedUserRole);
    }

    @Override
    public RoleResponseDto getRoleById(Long id) {
        return null;
    }

    @Override
    public List<RoleResponseDto> getAllRoles() {
        return List.of();
    }

    @Override
    public RoleResponseDto updateRole(Long id, RoleRequestDto roleRequestDto) {
        return null;
    }
}
