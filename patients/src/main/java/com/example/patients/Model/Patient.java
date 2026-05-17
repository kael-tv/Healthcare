package com.example.patients.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String firstName;
        private String lastName;

        private Date birthdayDate;

        private String phoneNumber;
        private String gender;
        private String mail;
}
