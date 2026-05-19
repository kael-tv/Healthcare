package com.example.WebApp.Controller;

import com.example.WebApp.Client.UserClient;
import com.example.WebApp.Dto.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

        private final UserClient userClient;
        private final PasswordEncoder passwordEncoder;

        public WebController(UserClient userClient, PasswordEncoder passwordEncoder) {
                this.userClient = userClient;
                this.passwordEncoder = passwordEncoder;
        }

        @GetMapping("/signup")
        public String showSignup(Model model) {
                model.addAttribute("user", new UserDto());
                return "signup"; //Look for src/main/resources/templates.signup.html
        }

        @PostMapping("/signup")
        public String processSignup(@ModelAttribute UserDto userDto) {
                userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
                userClient.addUser(userDto);
                return "redirect:/login";
        }

        @GetMapping("/login")
        public String showLogin() {
                return "login";
        }

        @GetMapping("/home")
        public String showHome() {
                return "home";
        }
}
