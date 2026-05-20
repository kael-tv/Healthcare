package com.example.doctors.repository;

import com.example.doctors.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository <Doctor, Long> {
}
