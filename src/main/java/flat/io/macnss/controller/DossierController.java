package flat.io.macnss.controller;


import com.google.gson.Gson;
import flat.io.macnss.dao.DossierDao;
import flat.io.macnss.entity.dossier.Dossier;
import flat.io.macnss.entity.refundable.Medication;
import flat.io.macnss.helper.JPA;
import flat.io.macnss.service.DossierService;
import flat.io.macnss.service.MedicationService;
import flat.io.macnss.service.PatientService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dossier")
public class DossierController {

    private DossierService dossierService;
    private PatientService patientService;

    private MedicationService medicationService;

    @GetMapping("/add")
    public ModelAndView dossierForm(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("refundables",dossierService.getRefundables());
        modelAndView.addObject("patients",patientService.getPatients());
        modelAndView.setViewName("agent/new.dossier");

        return modelAndView;
    }

    @PostMapping("/add")
    public String addDossier(@RequestParam(value = "speciality",defaultValue = "") List<Long> specialityIds,
                             @RequestParam(value = "analysis",defaultValue = "") List<Long> analysisIds,
                             @RequestParam(value = "radio",defaultValue = "") List<Long> radioIds,
                             @RequestParam(value = "medication",defaultValue = "") List<Long> medicationIds,
                             @RequestParam(value = "patient-id",defaultValue = "") Long patientId){

        dossierService.createDossier(specialityIds,analysisIds,radioIds,medicationIds,patientId);

        return "redirect:add";
    }

    @ResponseBody
    @GetMapping("/search-medication/{barcode}")
    public String searchMedication(@PathVariable("barcode") Long barcode){
        Medication medication = medicationService.getMedicationByBarCode(barcode);

        if(medication != null) medication.setDossiers(null);

        Gson gson = new Gson();
        return gson.toJson(medication);
    }

    @Autowired
    public void setDossierService(DossierService dossierService) {
        this.dossierService = dossierService;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired

    public void setMedicationService(MedicationService medicationService) {
        this.medicationService = medicationService;
    }
}
