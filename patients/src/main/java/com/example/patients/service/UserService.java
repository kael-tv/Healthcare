package com.example.patients.service;

import com.example.patients.exception.ResourceNotFoundException;
import com.example.patients.model.User;
import com.example.patients.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


        //Bean Injection
        private final UserRepository userRepository;

        public UserService(UserRepository userRepository) {
                this.userRepository = userRepository;
        }

        //Read
        public List<User> getAllUsers() {
                return userRepository.findAll();
        }

        public User getById(Long id) {
                return userRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id));
        }

        //Create
        public User addUser(User user) {
                return userRepository.save(user);
        }

        //Update
        public User updateUser(Long id, User user) {
                User existing = userRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id));

                existing.setUserName(user.getUserName());
                existing.setPassword(user.getPassword());
                return userRepository.save(existing);
        }

        //Delete
        public void deleteById(Long id) {
                userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id));
                userRepository.deleteById(id);
        }

}
