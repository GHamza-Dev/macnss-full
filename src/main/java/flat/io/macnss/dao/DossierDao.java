package flat.io.macnss.dao;

import flat.io.macnss.entity.dossier.Dossier;
import flat.io.macnss.helper.JPA;
import org.springframework.stereotype.Repository;

@Repository
public class DossierDao {

    public void save(Dossier dossier){
        JPA.wrap(entityManager -> entityManager.persist(dossier));
    }

}
