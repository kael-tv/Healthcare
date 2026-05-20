package com.example.doctors.service;


import com.example.doctors.exception.ResourceNotFoundException;
import com.example.doctors.model.Doctor;
import com.example.doctors.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {

        //Bean injection
        private final DoctorRepository doctorRepository;

        public DoctorService(DoctorRepository doctorRepository) {
                this.doctorRepository = doctorRepository;
        }

        //Read
        public List<Doctor> getAllDoctors() {
                return doctorRepository.findAll();
        }

        public Doctor getById(Long id) {
                return doctorRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Doctor not found with id: " + id));
        }

        public Doctor findByUserName(String userName) {
                return doctorRepository.findByUserName(userName)
                        .orElseThrow(()-> new ResourceNotFoundException("Doctor not found with this username"));
        }

        //Create
        public Doctor addDoctor(Doctor doctor) {
                return doctorRepository.save(doctor);
        }

        //Update
        public Doctor updateDoctor(Long id, Doctor doctor) {
                Doctor existing = doctorRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Doctor not found with id: " + id));

                existing.setUserName(doctor.getUserName());
                existing.setPassword(doctor.getPassword());
//                existing.setRole(doctor.getRole());
                return doctorRepository.save(existing);


        }

        //Delete
        public void deleteById(Long id) {
                doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id));
                doctorRepository.deleteById(id);
        }

}
