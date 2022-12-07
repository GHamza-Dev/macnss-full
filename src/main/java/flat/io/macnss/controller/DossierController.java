package flat.io.macnss.controller;


import flat.io.macnss.dao.DossierDao;
import flat.io.macnss.entity.dossier.Dossier;
import flat.io.macnss.entity.refundable.Medication;
import flat.io.macnss.helper.JPA;
import flat.io.macnss.service.DossierService;
import flat.io.macnss.service.PatientService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dossier")
public class DossierController {

    private DossierService dossierService;
    private PatientService patientService;

    @GetMapping("/add")
    public ModelAndView dossierForm(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("refundables",dossierService.getRefundables());
        modelAndView.addObject("patients",patientService.getPatients());
        modelAndView.setViewName("agent/new.dossier");

        return modelAndView;
    }

    @PostMapping("/add")
    public String addDossier(){

        Medication medication = new Medication();

        medication.setId(1);
        EntityManager em = JPA.entityManager();
        Medication medication1 = em.merge(medication);

        List<Medication> medications = new ArrayList<>();
        medications.add(medication1);

        Dossier dossier = new Dossier();
        dossier.setPatientId(1L);
        dossier.setMedications(medications);

        DossierDao dossierDao = new DossierDao();

        JPA.wrap(em,entityManager -> entityManager.persist(dossier));

        return "redirect:add";
    }

    @Autowired
    public void setDossierService(DossierService dossierService) {
        this.dossierService = dossierService;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }
}
