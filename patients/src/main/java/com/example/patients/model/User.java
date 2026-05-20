package com.example.patients.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @NotBlank(message = "Username is required")//NotBlank is prefered for String fields, NotNull for numeric fields
        @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters") //Size is intended to be used for arrays, Strings, collections and maps. @Max(9000) as en example of numeric max
        @Pattern(regexp = "^[a-zA-Z0-9_]{4,20}$", message = "Username can only contain letters, numbers and underscores")
        private String userName;

        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", message = "Password must contain at least one uppercase, one lowercase and one number")
        private String password;
//        private String role;

}
