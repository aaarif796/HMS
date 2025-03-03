package com.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.entity.Patient;
import com.hms.repository.PatientRepo;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepository;

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    

    public List<Patient> getLatestPatients(int count) {
        // Call the custom query method to fetch the latest patients
        return patientRepository.findTop5ByOrderByAdmissionDateDesc();
    }
    // You can add more service methods here for managing patient data as needed

    public Patient getPatientById(int patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }
}
