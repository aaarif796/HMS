package com.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.entity.PatientBill;

@Repository
public interface PatientBillRepo extends JpaRepository<PatientBill, Integer> {
    List<PatientBill> findAll();
    List<PatientBill> findTop5ByOrderByBillIdDesc();
}