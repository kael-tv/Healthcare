package com.example.patients.controller;

import com.example.patients.dto.PatientRequestDto;
import com.example.patients.dto.PatientResponseDto;
import com.example.patients.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {


        private final PatientService patientService;

        public PatientController(PatientService patientService) {
                this.patientService = patientService;
        }

        @GetMapping
        public ResponseEntity<List<PatientResponseDto>> getAllPatients() {
                return ResponseEntity.ok(patientService.getAllPatients());
        }

        @GetMapping("/{id}")
        public ResponseEntity<PatientResponseDto> getById (@PathVariable Long id) {
                return ResponseEntity.ok(patientService.getById(id));
        }

        @PostMapping
        public ResponseEntity<PatientResponseDto> addPatient(@RequestBody @Valid PatientRequestDto dto) {
                return ResponseEntity.status(HttpStatus.CREATED).body(patientService.addPatient(dto));
        }

        @PutMapping("/{id}")
        public ResponseEntity<PatientResponseDto> updatePatient(@PathVariable Long id, @RequestBody @Valid PatientRequestDto dto) {
                return ResponseEntity.ok(patientService.updatePatient(id, dto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
                patientService.deleteById(id);
                return ResponseEntity.noContent().build(); //204 no content
        }

}
