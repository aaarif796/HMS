package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.entity.PatientBill;
import com.hms.repository.PatientBillRepo;

@Service
public class PatientBillService {
    @Autowired
    private PatientBillRepo patientBillRepo;
    
    public void addPatientBill(PatientBill patientBill) {
        patientBillRepo.save(patientBill);
    }

    public List<PatientBill> getPatientBillList(int count) {
        return patientBillRepo.findTop5ByOrderByBillIdDesc();
    }
}
