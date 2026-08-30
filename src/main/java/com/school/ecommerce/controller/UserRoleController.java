package com.school.ecommerce.controller;

import com.school.ecommerce.dto.request.RoleRequestDto;
import com.school.ecommerce.dto.response.ApiResponse;
import com.school.ecommerce.dto.response.RoleResponseDto;
import com.school.ecommerce.service.UserRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class UserRoleController {
    private final UserRoleService userRoleService;

    @PostMapping
    public ApiResponse<RoleResponseDto> createRole(@Valid @RequestBody RoleRequestDto roleRequestDto) {
        RoleResponseDto roleResponseDto = userRoleService.createRole(roleRequestDto);
        return ApiResponse.success(roleResponseDto);
    }

    @GetMapping
    public ApiResponse<List<RoleResponseDto>> getRoles() {
        List<RoleResponseDto> roles = userRoleService.getAllRoles();
        return ApiResponse.success(roles);
    }
}
