package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hms.entity.Patient;
import com.hms.service.PatientService;

@Controller
@SessionAttributes("username") // Add session attribute for username
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/dashboard/pregister")
    public String showPatientRegistrationForm(Model model) {
        System.out.println("Showing Patient Registration Form");
        List<Patient> latestPatients = patientService.getLatestPatients(5);
        
        // Add latest patient entries to the model
        model.addAttribute("latestPatients", latestPatients);
        
        return "patientRegistration";
    }

    @PostMapping("/dashboard/pregistersubmit")
    public String registerPatient(@ModelAttribute Patient patient, RedirectAttributes redirectAttributes) {
        System.out.println("Registering Patient: " + patient);
        
        patientService.addPatient(patient);
        redirectAttributes.addFlashAttribute("successMessage", "Patient registered successfully");
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard/history")
    public String viewPatientHistory() {
        System.out.println("Viewing Patient History");
        return "patient_history";
    }
}
