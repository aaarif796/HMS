package com.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hms.entity.Prescription;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription,Integer>{
    List<Prescription> findAll();
    List<Prescription> findTop5ByOrderByPidDesc();
}
