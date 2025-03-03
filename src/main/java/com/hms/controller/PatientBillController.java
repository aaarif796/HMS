package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hms.entity.Patient;
import com.hms.entity.PatientBill;
import com.hms.entity.Prescription;
import com.hms.service.PatientBillService;
import com.hms.service.PatientService;
import com.hms.service.PrescriptionService;

@Controller
public class PatientBillController {

    @Autowired
    private PatientBillService patientBillService;

    @Autowired
    private PatientService patientService;
    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/dashboard/patientbillRegistration")
    public String showBillRegistration(Model model) {
        System.out.println("enter into registration form of bill");
        
        // Fetching patients to populate the dropdown
        model.addAttribute("prescriptionList",prescriptionService.getAllPrescriptions());

        List<PatientBill> latestpatientsBill = patientBillService.getPatientBillList(5);
        System.out.print(latestpatientsBill);
        model.addAttribute("latestpatientsBill",latestpatientsBill);
        return "patientbillRegistration";
    }

    @PostMapping("/dashboard/billregistersubmit")
    public String registerBill(@ModelAttribute PatientBill patientBill, @RequestParam("prescriptionId") int pid, RedirectAttributes redirectAttributes) {
        // Retrieving patient by ID
        // Patient patient = patientService.getPatientById(patientId);
        // patientBill.set(patient);
        Prescription prescription = prescriptionService.getPrescriptionById(pid);
        patientBill.setPrescription(prescription);
        // Saving patient bill
        patientBillService.addPatientBill(patientBill);

        // Adding success message
        redirectAttributes.addFlashAttribute("successMessage", "Patient bill registered successfully");

        return "redirect:/dashboard";
    }
}
