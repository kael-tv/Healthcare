package com.example.doctors.repository;

import com.example.doctors.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository <Doctor, Long> {

        Optional<Doctor> findByUserName(String userName);

        String userName(String userName);
}
