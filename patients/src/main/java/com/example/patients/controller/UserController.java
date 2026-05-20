package com.example.patients.controller;

import com.example.patients.model.User;
import com.example.patients.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/Users")

public class UserController {


        private final UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        @GetMapping
        public List<User> getAllUsers() {
                return userService.getAllUsers();
        }

        @GetMapping("/{id}")
        public ResponseEntity<User> getById (@PathVariable Long id) {
                User user = userService.getById(id);
                return ResponseEntity.ok(user);
        }

        @GetMapping("/by-username/{username}")
        public User findByUserName(@PathVariable String username) {
                return userService.findByUserName(username);
        }

        @GetMapping("/by-username/{username}")
        public User findByUserName(@PathVariable String username) {
                return userService.findByUserName(username);
        }

        @PostMapping
        public User addUser(@RequestBody User user) {
                return userService.addUser(user);
        }

        @PutMapping("/{id}")
        public User updateUser(@PathVariable Long id, @RequestBody User user) {
                return userService.updateUser(id, user);
        }

        @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable Long id) {
                userService.deleteById(id);
        }
}
