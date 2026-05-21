package com.example.doctors.mapper;

import com.example.doctors.dto.DoctorRequestDto;
import com.example.doctors.dto.DoctorResponseDto;
import com.example.doctors.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

        public Doctor toEntity(DoctorRequestDto dto) {
                Doctor doctors = new Doctor();
                doctors.setUserName(dto.getUserName());
                doctors.setPassword(dto.getPassword());
                return doctors;
        }

        public DoctorResponseDto toResponseDto(Doctor doctor) {
                DoctorResponseDto dto = new DoctorResponseDto();
                dto.setId(doctor.getId());
                dto.setUserName(doctor.getUserName());
                return dto;
        }

}
