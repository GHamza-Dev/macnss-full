package flat.io.macnss.dao;

import flat.io.macnss.entity.person.Person;
import flat.io.macnss.helper.JPA;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao{

    public Person selectByEmailAndPassword(String email, String password, Class clazz){
        Query query = JPA.entityManager().createQuery("SELECT p FROM "+clazz.getSimpleName()+" p WHERE p.email = :email");

        query.setParameter("email",email);

        Person person = null;

        try{
            person = (Person) query.getSingleResult();
        }catch(NoResultException e){
            System.out.println("No record found!");
        }

        if (person == null || !person.getPassword().equals(password)) {
            return null;
        }

        return person;
    }
}
