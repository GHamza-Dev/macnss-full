package flat.io.macnss.dao;

import flat.io.macnss.entity.person.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDao extends PersonDao{

    public Patient selectByEmailAndPassword(String email, String password){
        return (Patient) super.selectByEmailAndPassword(email,password,Patient.class);
    }

}
