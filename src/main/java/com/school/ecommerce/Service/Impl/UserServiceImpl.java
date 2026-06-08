package com.school.ecommerce.Service.Impl;

import com.school.ecommerce.Dto.Request.CreateUserRequestDto;
import com.school.ecommerce.Dto.Response.UserResponseDto;
import com.school.ecommerce.Exception.Constants.ErrorMessage;
import com.school.ecommerce.Exception.Custom.ResourceNotFoundException;
import com.school.ecommerce.Mapper.UserMapper;
import com.school.ecommerce.Model.User;
import com.school.ecommerce.Model.UserRole;
import com.school.ecommerce.Repository.UserRepository;
import com.school.ecommerce.Repository.UserRoleRepository;
import com.school.ecommerce.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
        if (userRepository.existsByEmail(createUserRequestDto.getEmail())) {
            throw new ResourceNotFoundException(ErrorMessage.USER_NOT_FOUND);
        }

        UserRole role = userRoleRepository.findById(createUserRequestDto.getRoleId())
                .orElseThrow(()  -> new ResourceNotFoundException(ErrorMessage.ROLE_NOT_FOUND));
        User user = userMapper.userDtoToEntity(createUserRequestDto);
        user.setRole(role);
        User savedUser = userRepository.save(user);
        return userMapper.userEntityToDto(savedUser);
    }

    @Override
    public UserResponseDto getUserByIdAndEmail(Long id, String email) {
        return null;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserResponseDto updateUser(Long id, CreateUserRequestDto createUserRequestDto) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
