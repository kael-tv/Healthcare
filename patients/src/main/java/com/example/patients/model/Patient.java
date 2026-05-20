package com.example.patients.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "First name is required")
        private String firstName;

        @NotBlank(message = "Last name is required")
        private String lastName;

        @NotNull(message = "Birthday date is required")
        private Date birthdayDate;

        @Pattern(regexp = "^(M|F|Other)$", message = "Gender must be M, F or Other")
        private String gender;

        @NotBlank
        private String address;

        /*
        ^0[0-9]{9}$ :
        ^ → start of the string
        0 → must start with 0
        [0-9] → any digit from 0 to 9
        {9} → repeated exactly 9 times
        $ → end of the string
         */
        @Pattern(regexp = "^0[0-9]{9}$", message = "Invalid phone number format")
        private String phoneNumber;

        @Email(message = "Invalid email format")
        @NotBlank(message = "Email is required")
        private String mail;
}
