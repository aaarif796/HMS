package com.hms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOCTOR")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    private String dName;
    private String dSpacialist; 
    private double consultCharge;
    private double salary;
    

    
    public Doctor(){
        super();
    }

    /**
     * @return int return the doctorId
     */
    public int getDoctorId() {
        return doctorId;
    }

    /**
     * @param doctorId the doctorId to set
     */
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * @return String return the dName
     */
    public String getDName() {
        return dName;
    }

    /**
     * @param dName the dName to set
     */
    public void setDName(String dName) {
        this.dName = dName;
    }

    /**
 * @return String return the dSpacialist
 */
public String getDSpacialist() {
    return dSpacialist;
}

/**
 * @param dSpacialist the dSpacialist to set
 */
public void setDSpacialist(String dSpacialist) {
    this.dSpacialist = dSpacialist;
}

    /**
     * @return double return the consultCharge
     */
    public double getConsultCharge() {
        return consultCharge;
    }

    /**
     * @param consultCharge the consultCharge to set
     */
    public void setConsultCharge(double consultCharge) {
        this.consultCharge = consultCharge;
    }

    /**
     * @return double return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Doctor [id=" + doctorId +" DoctorName=" + dName + " Doctor Spacilist=" + dSpacialist + " Consultant Charge =" + consultCharge+" Salary="+salary + "]";
    }
}
