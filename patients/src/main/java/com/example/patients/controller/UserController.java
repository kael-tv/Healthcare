package com.example.patients.controller;

import com.example.patients.dto.UserRequestDto;
import com.example.patients.dto.UserResponseDto;
import com.example.patients.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {


        private final UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        @GetMapping
        public ResponseEntity<List<UserResponseDto>> getAllUsers() {
                return ResponseEntity.ok(userService.getAllUsers());
        }

        @GetMapping("/{id}")
        public ResponseEntity<UserResponseDto> getById (@PathVariable Long id) {
                return ResponseEntity.ok(userService.getById(id));
        }


        @GetMapping("/by-username/{username}")
        public ResponseEntity<UserResponseDto> findByUserName(@PathVariable String username) {
                return ResponseEntity.ok(userService.findByUserName(username)); //200
        }

        @PostMapping
        public ResponseEntity<UserResponseDto> addUser(@RequestBody @Valid UserRequestDto dto) {
                return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(dto)); //201 Created
        }

        @PutMapping("/{id}")
        public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody @Valid UserRequestDto dto) {
                return ResponseEntity.ok(userService.updateUser(id, dto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
                userService.deleteById(id);
                return ResponseEntity.noContent().build(); //204 no content
        }
}
