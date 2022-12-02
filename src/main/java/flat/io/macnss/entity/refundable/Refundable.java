package flat.io.macnss.entity.refundable;

import jakarta.persistence.*;

@MappedSuperclass
public class Refundable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private Float repayment;

    public Refundable() {
    }

    public Refundable(String name, Float repayment) {
        this.name = name;
        this.repayment = repayment;
    }

    public Refundable(long id, String name, Float repayment) {
        this.id = id;
        this.name = name;
        this.repayment = repayment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRepayment() {
        return repayment;
    }

    public void setRepayment(Float repayment) {
        this.repayment = repayment;
    }
}
