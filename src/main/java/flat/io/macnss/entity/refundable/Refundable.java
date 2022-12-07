package flat.io.macnss.entity.refundable;

import jakarta.persistence.*;

@MappedSuperclass
public class Refundable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    public Refundable() {
    }

    public Refundable(String name) {
        this.name = name;
    }

    public Refundable(long id, String name) {
        this.id = id;
        this.name = name;
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
}
