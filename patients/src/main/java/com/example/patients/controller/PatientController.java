package com.example.patients.controller;
import com.example.patients.model.Patient;

import com.example.patients.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Patients")
public class PatientController {


        private final PatientService patientService;

        public PatientController(PatientService patientService) {
                this.patientService = patientService;
        }

        @GetMapping
        public ResponseEntity<List<Patient>> getAllPatients() {
                return ResponseEntity.ok(patientService.getAllPatients());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Patient> getById (@PathVariable Long id) {
                Patient patient = patientService.getById(id);
                return ResponseEntity.ok(patient);
        }

        @PostMapping
        public ResponseEntity<Patient> addPatient(@RequestBody @Valid Patient patient) {
                return ResponseEntity.status(HttpStatus.CREATED).body(patientService.addPatient(patient));
        }

        @PutMapping("/{id}")
        public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody @Valid Patient patient) {
                return ResponseEntity.ok(patientService.updatePatient(id, patient));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
                patientService.deleteById(id);
                return ResponseEntity.noContent().build(); //204 no content
        }

}
