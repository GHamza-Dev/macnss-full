package flat.io.macnss.entity.refundable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Radio extends Refundable{

    @Column
    private Float percentage;

    public Radio() {
    }

    public Radio(String name, Float percentage) {
        super(name);
        this.percentage = percentage;
    }

    public Radio(long id, String name, Float percentage) {
        super(id, name);
        this.percentage = percentage;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}
