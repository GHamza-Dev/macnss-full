package flat.io.macnss.entity.refundable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Radio extends Refundable{

    @Column
    private Float percentage;

    public Radio() {
    }

    public Radio(String name, Float repayment, Float percentage) {
        super(name, repayment);
        this.percentage = percentage;
    }

    public Radio(long id, String name, Float repayment, Float percentage) {
        super(id, name, repayment);
        this.percentage = percentage;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}
