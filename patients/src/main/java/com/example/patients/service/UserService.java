package com.example.patients.service;

import com.example.patients.dto.UserRequestDto;
import com.example.patients.dto.UserResponseDto;
import com.example.patients.exception.ResourceNotFoundException;
import com.example.patients.mapper.UserMapper;
import com.example.patients.model.User;
import com.example.patients.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


        //Bean Injection
        private final UserRepository userRepository;
        private final UserMapper userMapper;

        public UserService(UserRepository userRepository, UserMapper userMapper) {
                this.userRepository = userRepository;
                this.userMapper = userMapper;
        }

        //Read
        public List<UserResponseDto> getAllUsers() {
                return userRepository.findAll()
                        .stream()
                        .map(userMapper::toResponseDto)
                        .collect(Collectors.toList());
        }

        public UserResponseDto getById(Long id) {
                User user = userRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id));
                return userMapper.toResponseDto(user);

        }

        public UserResponseDto findByUserName(String userName) {
                User user = userRepository.findByUserName(userName)
                        .orElseThrow(()-> new ResourceNotFoundException("User not found with this username"));
                return userMapper.toResponseDto(user);

        }

        //Create
        public UserResponseDto addUser(UserRequestDto dto) {
                User user = userMapper.toEntity(dto);
                return userMapper.toResponseDto(userRepository.save(user));
        }

        //Update
        public UserResponseDto updateUser(Long id, UserRequestDto dto) {
                User existing = userRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id));

                existing.setUserName(dto.getUserName());
                existing.setPassword(dto.getPassword());
//                existing.setRole(user.getRole));
                return userMapper.toResponseDto(userRepository.save(existing));
        }

        //Delete
        public void deleteById(Long id) {
                userRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id));
                userRepository.deleteById(id);
        }

}
