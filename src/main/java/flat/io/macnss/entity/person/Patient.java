package flat.io.macnss.entity.person;

import flat.io.macnss.entity.dossier.Dossier;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Patient extends Person {

    @Column(name = "patient_number",unique = true)
    private Long patientNumber;

    @OneToMany(mappedBy = "patient")
    private List<Dossier> dossiers;

    public Patient() {
    }

    public Patient(String email, String username, String password, long patientNumber) {
        super(email, username, password);
        this.patientNumber = patientNumber;
    }

    public Patient(long id, String email, String username, String password, long patientNumber) {
        super(id, email, username, password);
        this.patientNumber = patientNumber;
    }

    public long getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(Long patientNumber) {
        this.patientNumber = patientNumber;
    }
}
