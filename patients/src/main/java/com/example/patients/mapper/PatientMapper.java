package com.example.patients.mapper;

import com.example.patients.dto.PatientRequestDto;
import com.example.patients.dto.PatientResponseDto;
import com.example.patients.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

        public Patient toEntity(PatientRequestDto dto) {
                Patient patient = new Patient();
                patient.setFirstName(dto.getFirstName());
                patient.setLastName(dto.getLastName());
                patient.setBirthdayDate(dto.getBirthdayDate());
                patient.setGender(dto.getGender());
                patient.setAddress(dto.getAddress());
                patient.setPhoneNumber(dto.getPhoneNumber());
                patient.setMail(dto.getMail());
                return patient;
        }

        public PatientResponseDto toResponseDto(Patient patient) {
                PatientResponseDto dto = new PatientResponseDto();
                dto.setId(patient.getId());
                dto.setFirstName(patient.getFirstName());
                dto.setLastName(patient.getLastName());
                dto.setBirthdayDate(patient.getBirthdayDate());
                dto.setGender(patient.getGender());
                dto.setAddress(patient.getAddress());
                dto.setPhoneNumber(patient.getPhoneNumber());
                dto.setMail(patient.getMail());
                return dto;
        }

        public void updateEntity(Patient existing, PatientRequestDto dto) {
                existing.setFirstName(dto.getFirstName());
                existing.setLastName(dto.getLastName());
                existing.setBirthdayDate(dto.getBirthdayDate());
                existing.setGender(dto.getGender());
                existing.setAddress(dto.getAddress());
                existing.setPhoneNumber(dto.getPhoneNumber());
                existing.setMail(dto.getMail());
        }
}
