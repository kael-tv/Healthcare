package com.example.doctors.service;


import com.example.doctors.dto.DoctorRequestDto;
import com.example.doctors.dto.DoctorResponseDto;
import com.example.doctors.exception.ResourceNotFoundException;
import com.example.doctors.mapper.DoctorMapper;
import com.example.doctors.model.Doctor;
import com.example.doctors.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

        //Bean injection
        private final DoctorRepository doctorRepository;
        private final DoctorMapper doctorMapper;

        public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
                this.doctorRepository = doctorRepository;
                this.doctorMapper = doctorMapper;
        }

        //Read
        public List<DoctorResponseDto> getAllDoctors() {
                return doctorRepository.findAll()
                        .stream()
                        .map(doctorMapper::toResponseDto)
                        .collect(Collectors.toList());
        }

        public DoctorResponseDto getById(Long id) {
                Doctor doctor = doctorRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Doctor not found with id: " + id));
                return doctorMapper.toResponseDto(doctor);

        }

        public DoctorResponseDto findByUserName(String userName) {
                Doctor doctor = doctorRepository.findByUserName(userName)
                        .orElseThrow(()-> new ResourceNotFoundException("Doctor not found with this username"));
                return doctorMapper.toResponseDto(doctor);
        }

        //Create
        public DoctorResponseDto addDoctor(DoctorRequestDto dto) {
                Doctor doctor = doctorMapper.toEntity(dto);
                return doctorMapper.toResponseDto(doctorRepository.save(doctor));
        }

        //Update
        public DoctorResponseDto updateDoctor(Long id, DoctorRequestDto dto) {
                Doctor existing = doctorRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Doctor not found with id: " + id));

                existing.setUserName(dto.getUserName());
                existing.setPassword(dto.getPassword());
//                existing.setRole(doctor.getRole());
                return doctorMapper.toResponseDto(doctorRepository.save(existing));


        }

        //Delete
        public void deleteById(Long id) {
                doctorRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id));
                doctorRepository.deleteById(id);
        }

}
