package com.example.patients.service;

import com.example.patients.dto.PatientRequestDto;
import com.example.patients.dto.PatientResponseDto;
import com.example.patients.exception.ResourceNotFoundException;
import com.example.patients.mapper.PatientMapper;
import com.example.patients.model.Patient;
import com.example.patients.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

        //Bean injection
        private final PatientRepository patientRepository;
        private final PatientMapper patientMapper;

        public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
                this.patientRepository = patientRepository;
                this.patientMapper = patientMapper;
        }

        //Read
        public List<PatientResponseDto> getAllPatients() {
                return patientRepository.findAll()
                        .stream()
                        .map(patientMapper::toResponseDto)
                        .collect(Collectors.toList());
        }

        public PatientResponseDto getById(Long id) {
                Patient patient = patientRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
                return patientMapper.toResponseDto(patient);
        }

        //Create
        public PatientResponseDto addPatient(PatientRequestDto dto) {
                Patient patient = patientMapper.toEntity(dto);
                return patientMapper.toResponseDto(patientRepository.save(patient));
        }

        //Update
        public PatientResponseDto updatePatient(Long id, PatientRequestDto dto) {
                Patient existing = patientRepository.findById(id).
                        orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
                patientMapper.updateEntity(existing, dto);
                return patientMapper.toResponseDto(patientRepository.save(existing));
        }

        //Delete
        public void deleteById(Long id) {
                patientRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
                patientRepository.deleteById(id);
        }





}
