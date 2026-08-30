package com.school.ecommerce.service.impl;

import com.school.ecommerce.dto.request.CreateUserRequestDto;
import com.school.ecommerce.dto.request.UpdateUserRequestDto;
import com.school.ecommerce.dto.response.UserResponseDto;
import com.school.ecommerce.exception.business.ResourceAlreadyExistsException;
import com.school.ecommerce.exception.business.ResourceNotFoundException;
import com.school.ecommerce.mapper.UserMapper;
import com.school.ecommerce.model.User;
import com.school.ecommerce.model.UserRole;
import com.school.ecommerce.repository.UserRepository;
import com.school.ecommerce.repository.UserRoleRepository;
import com.school.ecommerce.service.UserService;
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
            throw ResourceAlreadyExistsException.byField("User", "email", createUserRequestDto.getEmail());
        }
        User user = userMapper.userDtoToEntity(createUserRequestDto);
        if (createUserRequestDto.getRoleId() != null) {
            UserRole role = userRoleRepository.findById(createUserRequestDto.getRoleId())
                    .orElseThrow(() -> ResourceNotFoundException.byId("Role", createUserRequestDto.getRoleId()));
            user.setRole(role);
        }
        User savedUser = userRepository.save(user);
        return userMapper.userEntityToDto(savedUser);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> ResourceNotFoundException.byId("User", id)
        );

        return userMapper.userEntityToDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userEntityToDto)
                .toList();
    }

    @Override
    public UserResponseDto updateUser(Long id, UpdateUserRequestDto updateUserRequestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.byId("User", id));

        if (!user.getEmail().equals(updateUserRequestDto.getEmail()) && userRepository.existsByEmail(updateUserRequestDto.getEmail())) {
            throw ResourceAlreadyExistsException.byField("User", "email", updateUserRequestDto.getEmail());
        }

        userMapper.updateUserFromDto(updateUserRequestDto, user);

        if (updateUserRequestDto.getRoleId() != null) {
            UserRole role = userRoleRepository.findById(updateUserRequestDto.getRoleId())
                    .orElseThrow(() -> ResourceNotFoundException.byId("Role", updateUserRequestDto.getRoleId()));
            user.setRole(role);
        }
        User saveUser = userRepository.save(user);
        return userMapper.userEntityToDto(saveUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.byId("User", id));
        userRepository.delete(user);
    }
}
