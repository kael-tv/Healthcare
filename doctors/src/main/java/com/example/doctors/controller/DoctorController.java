package com.example.doctors.controller;

import com.example.doctors.dto.DoctorRequestDto;
import com.example.doctors.dto.DoctorResponseDto;
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
        public ResponseEntity<List<DoctorResponseDto>> getAllDoctors() {
                return ResponseEntity.ok(doctorService.getAllDoctors());
        }

        @GetMapping("/{id}")
        public ResponseEntity<DoctorResponseDto> getById(@PathVariable Long id) {
                return ResponseEntity.ok(doctorService.getById(id));
        }

        @GetMapping("/username/{username}")
        public ResponseEntity<DoctorResponseDto> findByUserName(@PathVariable String username) {
                return ResponseEntity.ok(doctorService.findByUserName(username)); // 200
        }

        //Create
        @PostMapping
        public ResponseEntity<DoctorResponseDto> addDoctor (@RequestBody @Valid DoctorRequestDto dto) {
                return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.addDoctor(dto)); // 201 Created
        }

        //Update
        @PutMapping("/{id}")
        public ResponseEntity<DoctorResponseDto> updateDoctor(@PathVariable Long id, @RequestBody @Valid DoctorRequestDto dto) {
                return ResponseEntity.ok(doctorService.updateDoctor(id, dto));
        }

        //Delete
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteById(@PathVariable Long id) {
                doctorService.deleteById(id);
                return ResponseEntity.noContent().build(); //204 no content

        }
}
