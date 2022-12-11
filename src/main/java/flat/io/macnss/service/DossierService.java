package flat.io.macnss.service;

import flat.io.macnss.dao.DossierDao;
import flat.io.macnss.dao.RefundableDao;
import flat.io.macnss.entity.dossier.Dossier;
import flat.io.macnss.entity.person.Patient;
import flat.io.macnss.entity.refundable.*;
import flat.io.macnss.helper.JPA;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DossierService {

    private RefundableDao refundableDao;
    private DossierDao dossierDao;

    public Dossier createDossier(List<Long> specialityIds, List<Long> analysisIds,
                                 List<Long> radioIds, List<Long> medicationIds, Long patientId){

        EntityManager em = JPA.entityManager();

        List<Speciality> specialities = new ArrayList<>();
        List<Medication> medications = new ArrayList<>();
        List<Analysis> analyses = new ArrayList<>();
        List<Radio> radios = new ArrayList<>();

        for(Long id: specialityIds){
            Speciality speciality = new Speciality();
            speciality.setId(id);
            speciality = em.merge(speciality);
            specialities.add(speciality);
        }

        for(Long id: medicationIds){
            Medication medication = new Medication();
            medication.setId(id);
            medication = em.merge(medication);
            medications.add(medication);
        }

        for(Long id: analysisIds){
            Analysis analysis = new Analysis();
            analysis.setId(id);
            analysis = em.merge(analysis);
            analyses.add(analysis);
        }

        for(Long id: radioIds){
            Radio radio = new Radio();
            radio.setId(id);
            radio = em.merge(radio);
            radios.add(radio);
        }

//        Patient patient = new Patient();
//        patient.setId(patientId);
//
//        patient = em.merge(patient);

        Dossier dossier = new Dossier();
        dossier.setPatientId(patientId);
        dossier.setMedications(medications);
        dossier.setAnalyses(analyses);
        dossier.setRadios(radios);
        dossier.setSpecialities(specialities);

        dossierDao.save(em,dossier);

        return null;
    }

    public HashMap<String, List<? extends Refundable>> getRefundables(){
        HashMap<String,List<? extends Refundable>> refundables = new HashMap<>();

        List<Medication> medications =  (List<Medication>) refundableDao.getAll(Medication.class);
        List<Speciality> specialities = (List<Speciality>) refundableDao.getAll(Speciality.class);
        List<Analysis> analyses = (List<Analysis>) refundableDao.getAll(Analysis.class);
        List<Radio> radios = (List<Radio>) refundableDao.getAll(Radio.class);

        refundables.put("medications",medications);
        refundables.put("specialities",specialities);
        refundables.put("analyses",analyses);
        refundables.put("radios",radios);

        return refundables;
    }

    @Autowired
    public void setRefundableDao(RefundableDao refundableDao) {
        this.refundableDao = refundableDao;
    }

    @Autowired
    public void setDossierDao(DossierDao dossierDao) {
        this.dossierDao = dossierDao;
    }
}
