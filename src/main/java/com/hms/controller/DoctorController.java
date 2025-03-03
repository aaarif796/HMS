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

import com.hms.service.DoctorService;
import com.hms.entity.Doctor;

@Controller
@SessionAttributes("username")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/dashboard/dRegistration")
    public String showPatientRegistrationForm(Model model) {
        System.out.println("Showing Doctor Registration Form");
        List<Doctor> latestDoctors = doctorService.getLatestDoctors(5);
        System.out.println(latestDoctors);
        // Add latest patient entries to the model
        model.addAttribute("latestDoctors", latestDoctors);
        
        return "doctorRegistration";
    }

    @PostMapping("/dashboard/dregistersubmit")
    public String registerPatient(@ModelAttribute Doctor doctor, RedirectAttributes redirectAttributes) {
        System.out.println("Registering Patient: " + doctor);
        
        doctorService.addDoctor(doctor);
        redirectAttributes.addFlashAttribute("successMessage", "Doctor registered successfully");
        return "redirect:/dashboard";
    }
}
