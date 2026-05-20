package com.example.doctors.controller;

import com.example.doctors.model.Doctor;
import com.example.doctors.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

        private final DoctorService doctorService;
        public DoctorController(DoctorService doctorService) {
                this.doctorService = doctorService;
        }

        //Read
        @GetMapping
        public ResponseEntity<List<Doctor>> getAllDoctors() {
                return ResponseEntity.ok(doctorService.getAllDoctors());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Doctor> getById(@PathVariable Long id) {
                Doctor doctor = doctorService.getById(id);
                return ResponseEntity.ok(doctor);
        }

        @GetMapping("/username/{username}")
        public ResponseEntity<Doctor> findByUserName(@PathVariable String username) {
                return ResponseEntity.ok(doctorService.findByUserName(username)); // 200
        }

        //Create
        @PostMapping
        public ResponseEntity<Doctor> addDoctor (@RequestBody @Valid Doctor doctor) {
                return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.addDoctor(doctor)); // 201 Created
        }

        //Update
        @PutMapping("/{id}")
        public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody @Valid Doctor doctor) {
                return ResponseEntity.ok(doctorService.updateDoctor(id, doctor));
        }

        //Delete
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteById(@PathVariable Long id) {
                doctorService.deleteById(id);
                return ResponseEntity.noContent().build(); //204 no content

        }
}
