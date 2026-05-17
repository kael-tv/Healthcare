package com.example.patients.Service;

import com.example.patients.Model.Patient;
import com.example.patients.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

        private PatientRepository patientRepository;

        public PatientService(PatientRepository patientRepository) {
                this.patientRepository = patientRepository;
        }

        public List<Patient> getAllPatients() {
                return patientRepository.findAll();
        }

        public Patient addPatient(Patient patient) {
                return patientRepository.save(patient); ///TODO
        }
}
