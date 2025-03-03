package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.entity.Doctor;
import com.hms.entity.Patient;
import com.hms.entity.Prescription;
import com.hms.repository.DoctorRepo;
import com.hms.repository.PatientRepo;
import com.hms.repository.PrescriptionRepo;

@Service
public class PrescriptionService {
    
    @Autowired
    private PrescriptionRepo prescriptionRepo;
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private DoctorRepo doctorRepo;
    

    public void addPrescription(Prescription prescription){
      

     
        prescriptionRepo.save(prescription);
    }
    public List<Prescription> getAllPrescriptions(){
        return prescriptionRepo.findAll();
    }
    public List<Prescription> getLatestPrescriptions(int count) {
        return prescriptionRepo.findTop5ByOrderByPidDesc();
    }
    public Prescription getPrescriptionById(int pid) {
        return prescriptionRepo.findById(pid).orElse(null);
    }
    
}
