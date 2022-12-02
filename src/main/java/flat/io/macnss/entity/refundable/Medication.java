package flat.io.macnss.entity.refundable;

import flat.io.macnss.entity.dossier.Dossier;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Medication extends Refundable {
    @ManyToMany(mappedBy = "medications")
    private List<Dossier> dossiers;
}
