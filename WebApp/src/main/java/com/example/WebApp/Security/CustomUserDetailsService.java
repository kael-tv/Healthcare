package com.example.WebApp.Security;

import com.example.WebApp.Client.UserClient;
import com.example.WebApp.Dto.UserDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

///TODO
        private final UserClient userClient;

        public CustomUserDetailsService(UserClient userClient) {
                this.userClient = userClient;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserDto userDto = userClient.findByUserName(username);
                if (userDto == null) {
                        throw new UsernameNotFoundException("User not found: " + username);
                }
                return User.builder()
                        .username(userDto.getUserName())
                        .password(userDto.getPassword())
                        .roles("USER")
                        .build();
        }
}
