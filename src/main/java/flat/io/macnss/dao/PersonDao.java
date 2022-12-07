package flat.io.macnss.dao;

import flat.io.macnss.entity.person.Person;
import flat.io.macnss.entity.refundable.Refundable;
import flat.io.macnss.helper.JPA;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDao{

    public List<? extends Person> getAll(Class clazz) {
        Query query = JPA.entityManager().createQuery("SELECT p FROM "+clazz.getSimpleName()+" p");
        return query.getResultList();
    }

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

    public void save(Person person){
        JPA.wrap(entityManager -> entityManager.persist(person));
    }
}
