package flat.io.macnss.entity.refundable;

import flat.io.macnss.entity.dossier.Dossier;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Medication extends Refundable {

    @Column
    private Float repayment;

    @ManyToMany(mappedBy = "medications")
    private List<Dossier> dossiers;

    public Medication() {
    }

    public Medication(String name, Float repayment, Float repayment1) {
        super(name, repayment);
        this.repayment = repayment1;
    }

    public Medication(long id, String name, Float repayment, Float repayment1) {
        super(id, name, repayment);
        this.repayment = repayment1;
    }

    public Float getRepayment() {
        return repayment;
    }

    public void setRepayment(Float repayment) {
        this.repayment = repayment;
    }
}
