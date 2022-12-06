package flat.io.macnss.dao;

import flat.io.macnss.entity.person.Agent;
import org.springframework.stereotype.Repository;

@Repository
public class AgentDao extends PersonDao{

    public Agent selectByEmailAndPassword(String email, String password){
        return (Agent) super.selectByEmailAndPassword(email,password,Agent.class);
    }
}
