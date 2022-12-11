package flat.io.macnss.dao;

import flat.io.macnss.entity.person.Patient;
import flat.io.macnss.helper.JPA;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDao extends PersonDao{

    public Patient selectPatientByNumber(Long patientNumber){
        Query query = JPA.entityManager().createQuery("SELECT p FROM Patient p WHERE p.patientNumber = :patientNumber");

        query.setParameter("patientNumber",patientNumber);

        Patient patient = null;

        try{
            patient = (Patient) query.getSingleResult();
        }catch(NoResultException e){
            System.out.println("No record found!");
        }finally {
            return patient;
        }
    }
    public Patient selectByEmailAndPassword(String email, String password){
        return (Patient) super.selectByEmailAndPassword(email,password,Patient.class);
    }

    public List<Patient> getAll(){
        return (List<Patient>) super.getAll(Patient.class);
    }

}
