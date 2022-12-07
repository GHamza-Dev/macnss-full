package flat.io.macnss.service;

import flat.io.macnss.dao.DossierDao;
import flat.io.macnss.dao.RefundableDao;
import flat.io.macnss.entity.dossier.Dossier;
import flat.io.macnss.entity.refundable.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DossierService {

    private RefundableDao refundableDao;
    private DossierDao dossierDao;

    public Dossier createDossier(Long medId,Long patId){
        return null;
    }

    public HashMap<String, List<? extends Refundable>> getRefundables(){
        HashMap<String,List<? extends Refundable>> refundables = new HashMap<>();

        List<Medication> medications =  (List<Medication>) refundableDao.getAll(Medication.class);
        List<Speciality> specialities = (List<Speciality>) refundableDao.getAll(Speciality.class);
        List<Analysis> analyses = (List<Analysis>) refundableDao.getAll(Analysis.class);
        List<Radio> radios = (List<Radio>) refundableDao.getAll(Radio.class);

        refundables.put("medications",medications);
        refundables.put("specialities",specialities);
        refundables.put("analyses",analyses);
        refundables.put("radios",radios);

        return refundables;
    }

    @Autowired
    public void setRefundableDao(RefundableDao refundableDao) {
        this.refundableDao = refundableDao;
    }

    @Autowired
    public void setDossierDao(DossierDao dossierDao) {
        this.dossierDao = dossierDao;
    }
}
