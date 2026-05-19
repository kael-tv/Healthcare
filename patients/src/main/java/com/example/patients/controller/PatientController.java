package com.example.patients.controller;

import com.example.patients.model.Patient;
import com.example.patients.service.PatientService;
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
        public ResponseEntity <List<Patient>> getAllPatients() {
                return ResponseEntity.ok(patientService.getAllPatients()); ///TODO
        }

        @GetMapping("/{id}")
        public Patient getById (@PathVariable Long id) {
                return patientService.getById(id);
        }

        @PostMapping
        public Patient addPatient(@RequestBody Patient patient) {
                return patientService.addPatient(patient);
        }

        @PutMapping("/{id}")
        public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
                return patientService.updatePatient(id, patient);
        }

        @DeleteMapping("/{id}")
        public void deletePatient(@PathVariable Long id) {
                patientService.deleteById(id);
        }

}
