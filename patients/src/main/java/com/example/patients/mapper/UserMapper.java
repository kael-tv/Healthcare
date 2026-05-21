package com.example.patients.mapper;

import com.example.patients.dto.UserRequestDto;
import com.example.patients.dto.UserResponseDto;
import com.example.patients.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

        public User toEntity(UserRequestDto dto) {
                User user = new User();
                user.setUserName(dto.getUserName());
                user.setPassword(dto.getPassword());
                return user;
        }

        public UserResponseDto toResponseDto(User user) {
                UserResponseDto dto = new UserResponseDto();
                dto.setId(user.getId());
                dto.setUserName(user.getUserName());
                return dto;
        }

}
