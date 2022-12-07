package flat.io.macnss.entity.refundable;

import flat.io.macnss.entity.dossier.Dossier;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Medication extends Refundable {

    @Column(name = "bar_code")
    private Long barCode;
    @Column
    private Float repayment;

    @ManyToMany(mappedBy = "medications")
    private List<Dossier> dossiers;

    public Medication() {
    }

    public Medication(String name, Long barCode, Float repayment) {
        super(name);
        this.barCode = barCode;
        this.repayment = repayment;
    }

    public Medication(long id, String name, Long barCode, Float repayment) {
        super(id, name);
        this.barCode = barCode;
        this.repayment = repayment;
    }

    public Float getRepayment() {
        return repayment;
    }

    public void setRepayment(Float repayment) {
        this.repayment = repayment;
    }

    public Long getBarCode() {
        return barCode;
    }

    public void setBarCode(Long barCode) {
        this.barCode = barCode;
    }
}
