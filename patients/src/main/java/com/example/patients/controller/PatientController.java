package com.example.patients.controller;
import com.example.patients.model.Patient;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Patients")
public class PatientController {


        private final com.example.patients.service.PatientService patientService;

        public PatientController(com.example.patients.service.PatientService patientService) {
                this.patientService = patientService;
        }

        @GetMapping
        public List<Patient> getAllPatients() {
                return patientService.getAllPatients();
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
