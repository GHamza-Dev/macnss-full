package flat.io.macnss.entity.refundable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Speciality extends Refundable{

    @Column
    private Float repayment;

    @Column(name = "medication_refundable")
    private Boolean medicationRefundable;

    public Speciality() {
    }

    public Speciality(String name, Float repayment, Boolean medicationRefundable) {
        super(name);
        this.repayment = repayment;
        this.medicationRefundable = medicationRefundable;
    }

    public Speciality(long id, String name, Float repayment, Boolean medicationRefundable) {
        super(id, name);
        this.repayment = repayment;
        this.medicationRefundable = medicationRefundable;
    }

    public Boolean getMedicationRefundable() {
        return medicationRefundable;
    }

    public void setMedicationRefundable(Boolean medicationRefundable) {
        this.medicationRefundable = medicationRefundable;
    }

    public Float getRepayment() {
        return repayment;
    }

    public void setRepayment(Float repayment) {
        this.repayment = repayment;
    }
}
