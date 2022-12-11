package flat.io.macnss.service;

import flat.io.macnss.dao.MedicationDao;
import flat.io.macnss.entity.refundable.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationService {
    private MedicationDao medicationDao;

    public Medication getMedicationByBarCode(Long barCode){
        return medicationDao.selectMedicationByBarCode(barCode);
    }

    @Autowired
    public void setMedicationDao(MedicationDao medicationDao) {
        this.medicationDao = medicationDao;
    }
}
