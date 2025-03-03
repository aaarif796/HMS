package com.hms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PATIENT_BILL")
public class PatientBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;
    
    
    @OneToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;
    
    private double medicineCost;
    private double roomCharge;
    private double serviceCharge;
    private double testCharge;
    private double totalCost;

    public PatientBill() {
        super();
    }

    public double getTestCharge() {
        return testCharge;
    }
    public void setTestCharge(double testCharge) {
        this.testCharge = testCharge;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public double getMedicineCost() {
        return medicineCost;
    }

    public void setMedicineCost(double medicineCost) {
        this.medicineCost = medicineCost;
    }

    public double getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(double roomCharge) {
        this.roomCharge = roomCharge;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
    @Override
    public String toString() {
        return "PatientBill [billId=" + billId + ", prescription=" + prescription +
               ", medicineCost=" + medicineCost + ", roomCharge=" + roomCharge + ", serviceCharge=" + serviceCharge + ", medical terst charge="+testCharge+
               ", totalCost=" + totalCost + "]";
    }
}
