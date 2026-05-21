package com.example.patients.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PatientResponseDto {

        private Long id;

        private String firstName;
        private String lastName;

        private Date birthdayDate;

        private String gender;
        private String address;
        private String phoneNumber;
        private String mail;
}
