package com.example.patients.Controller;

import com.example.patients.Model.User;
import com.example.patients.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        public User getById (@PathVariable Long id) {
                return userService.getById(id);
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
