package flat.io.macnss.dao;

import flat.io.macnss.entity.refundable.Refundable;
import flat.io.macnss.helper.JPA;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RefundableDao {

    public List<? extends  Refundable> getAll(Class clazz) {
        Query query = JPA.entityManager().createQuery("SELECT r FROM "+clazz.getSimpleName()+" r");
        return query.getResultList();
    }
}
