package flat.io.macnss.controller;

import flat.io.macnss.entity.person.Patient;
import flat.io.macnss.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/add")
    public String addPatientForm(){
        return "agent/new.patient";
    }

    @PostMapping("/add")
    public String addPatient(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            @RequestParam("username") String username,
                            @RequestParam("patient-number") Long patientNumber){

        Patient patient = patientService.createPatient(email,password,username,patientNumber);

        if (patient == null) {
            System.out.println("Something went wrong while adding patient!!!");
        }else {
            System.out.println("Patient added successfully");
        }

        return "redirect:add";
    }
}
