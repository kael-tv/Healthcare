package com.example.doctors.controller;

import com.example.doctors.model.Doctor;
import com.example.doctors.service.DoctorService;


import java.util.List;

///TODO Vérif crud
@RestController
public class DoctorController {
        private final DoctorService doctorService;
        public DoctorController(DoctorService doctorService) {
                this.doctorService = doctorService;
        }

        @PostMapping
        public Doctor create (@RequestBody Doctor doctor) {
                return doctorService.addDoctor(doctor);
        }

        @GetMapping
        public List<Doctor> getAllDoctors {
                return doctorService.getAllDoctors();
        }



}
