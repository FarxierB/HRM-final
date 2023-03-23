package sr.unasat.service;

import sr.unasat.dao.AfdelingDAO;
import sr.unasat.entity.Afdeling;

import java.util.List;

public class AfdelingService {
    private AfdelingDAO afdelingDAO = new AfdelingDAO();

    public List<Afdeling> getAllAfdelingen(){return afdelingDAO.findAllAfdelingen();}

    public  Afdeling getAfdelingById(int afdelingId){return  afdelingDAO.findAfdelingById(afdelingId);}

    public Afdeling insertAfdeling(Afdeling afdeling) {
        return afdelingDAO.insertAfdeling(afdeling);
    }
}
