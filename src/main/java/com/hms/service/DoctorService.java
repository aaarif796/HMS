package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.entity.Doctor;
import com.hms.repository.DoctorRepo;


@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepository;

    public void addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<Doctor> getLatestDoctors(int count) {
        // Call the custom query method to fetch the latest patients
        return doctorRepository.findTop5ByOrderByDoctorIdDesc();
    }

    public Doctor getDoctorById(int doctorId) {
        return doctorRepository.findById(doctorId).orElse(null);
    }

}
