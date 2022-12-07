package flat.io.macnss.service;

import flat.io.macnss.dao.PatientDao;
import flat.io.macnss.entity.person.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientDao patientDao;

    @Autowired
    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public Patient createPatient(String email, String password, String username, Long patientNumber){
        Patient patient = new Patient(email,username,password,patientNumber);
        patientDao.save(patient);
        return patient.getId() != null ? patient : null;
    }

    public List<Patient> getPatients(){
        return patientDao.getAll();
    }
}
