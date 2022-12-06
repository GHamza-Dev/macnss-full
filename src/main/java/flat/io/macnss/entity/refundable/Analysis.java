package flat.io.macnss.entity.refundable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Analysis extends Refundable{

    @Column
    private Float percentage;

    public Analysis() {
    }

    public Analysis(String name, Float repayment, Float percentage) {
        super(name, repayment);
        this.percentage = percentage;
    }

    public Analysis(long id, String name, Float repayment, Float percentage) {
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
