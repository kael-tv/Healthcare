package com.example.patients.Service;

import com.example.patients.Exception.ResourceNotFoundException;
import com.example.patients.Model.User;
import com.example.patients.Repository.UserRepository;
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

        public User findByUserName(String userName) {
                return userRepository.findByUserName(userName)
                        .orElseThrow(()-> new ResourceNotFoundException("User not found with this username"));
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
