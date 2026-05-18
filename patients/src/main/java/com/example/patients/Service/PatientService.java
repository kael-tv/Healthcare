package com.example.patients.Service;

import com.example.patients.Model.Patient;
import com.example.patients.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientService {

        //Bean injection
        private final PatientRepository patientRepository;

        public PatientService(PatientRepository patientRepository) {
                this.patientRepository = patientRepository;
        }

        //Read
        public List<Patient> getAllPatients() {
                return patientRepository.findAll();
        }

        public Patient getById(Long id) {
                return patientRepository.findById(id).orElseThrow();
        }

        //Create
        public Patient addPatient(Patient patient) {
                return patientRepository.save(patient);
        }

        //Update
        public Patient updatePatient(Long id, Patient patient) {
                Patient existing = patientRepository.findById(id).orElseThrow();
                existing.setFirstName(patient.getFirstName());
                existing.setLastName(patient.getLastName());
                existing.setBirthdayDate(patient.getBirthdayDate());
                existing.setGender(patient.getGender());
                existing.setAddress(patient.getAddress());
                existing.setPhoneNumber(patient.getPhoneNumber());
                existing.setMail(patient.getMail());
                return patientRepository.save(existing);
        }

        //Delete
        public void deleteById(Long id) {
                patientRepository.deleteById(id);
        }





}
