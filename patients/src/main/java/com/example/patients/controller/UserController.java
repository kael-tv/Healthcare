package com.example.patients.controller;

import com.example.patients.model.User;
import com.example.patients.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
        public ResponseEntity<List<User>> getAllUsers() {
                return ResponseEntity.ok(userService.getAllUsers());
        }

        @GetMapping("/{id}")
        public ResponseEntity<User> getById (@PathVariable Long id) {
                User user = userService.getById(id); // Instantiate the object to return it in the ResponseEntity
                return ResponseEntity.ok(user);
        }


        @GetMapping("/by-username/{username}")
        public ResponseEntity<User> findByUserName(@PathVariable String username) {
                return ResponseEntity.ok(userService.findByUserName(username)); //200
        }

        @PostMapping
        public ResponseEntity<User> addUser(@RequestBody @Valid User user) {
                return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user)); //201 Created
        }

        @PutMapping("/{id}")
        public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
                return ResponseEntity.ok(userService.updateUser(id, user));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
                userService.deleteById(id);
                return ResponseEntity.noContent().build(); //204 no content
        }
}
