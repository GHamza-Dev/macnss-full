package flat.io.macnss.service;

import flat.io.macnss.dao.AgentDao;
import flat.io.macnss.dao.PatientDao;
import flat.io.macnss.entity.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private AgentDao agentDao;
    private PatientDao patientDao;

    public Person authenticate(String email,String password,String role){
        Person person = null;
        if(role.equals("agent")){
            person = agentDao.selectByEmailAndPassword(email,password);
        } else if (role.equals("patient")) {
            person = patientDao.selectByEmailAndPassword(email,password);
        }
        return person;
    }

    @Autowired
    public void setAgentDao(AgentDao agentDao) {
        this.agentDao = agentDao;
    }

    @Autowired
    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }
}
