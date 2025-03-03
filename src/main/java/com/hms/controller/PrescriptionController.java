package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hms.entity.Doctor;
import com.hms.entity.Patient;
import com.hms.entity.Prescription;
import com.hms.service.DoctorService;
import com.hms.service.PatientService;
import com.hms.service.PrescriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@SessionAttributes("username")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prService;
    
    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/dashboard/prsRegistration")
    public String showPrescriptionRegistration(Model model) {
        System.out.println("Enter into prescription registration section");
        model.addAttribute("patientList", patientService.getAllPatients());
        model.addAttribute("doctorList", doctorService.getAllDoctors());

        List<Prescription> latestPrescriptions = prService.getLatestPrescriptions(5);
        System.out.println(latestPrescriptions);
        model.addAttribute("latestPrescriptions",latestPrescriptions);


        

        return "prescriptionRegistration";
    }

    @PostMapping("/dashboard/prsregistersubmit")
    public String registerPrescription(@ModelAttribute Prescription prsregistration,@RequestParam("doctorId") int doctorId, @RequestParam("patientId") int patientId ,RedirectAttributes redirectAttributes) {
        
        System.out.println("RegisterPrescription: " + prsregistration);


        // Set the selected doctorId and patientId to the Prescription object
        Doctor doctor = doctorService.getDoctorById(doctorId);
        Patient patient = patientService.getPatientById(patientId);
        prsregistration.setDoctor(doctor);
        prsregistration.setPatient(patient);

        // Save the Prescription object
        prService.addPrescription(prsregistration);

        // Add success message
        redirectAttributes.addFlashAttribute("successMessage", "Prescription registered successfully");

        return "redirect:/dashboard";
    }
    
    
}
