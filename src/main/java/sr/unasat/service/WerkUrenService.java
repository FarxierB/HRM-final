package sr.unasat.service;

import sr.unasat.dao.WerkUrenDAO;
import sr.unasat.entity.WerkUren;

import java.util.List;

public class WerkUrenService {
    private WerkUrenDAO werkUrenDAO = new WerkUrenDAO();

    public List<WerkUren> findAllWerkUren() {
        return werkUrenDAO.findAllWerkUren();
    }

    public WerkUren findWerkUrenById(int id) {
        return werkUrenDAO.findWerkUrenById(id);
    }

    public WerkUren insertWerkUren(WerkUren task) {
        return werkUrenDAO.insertWerkUren(task);
    }

    public int updateWerkUren(WerkUren task) {
        return werkUrenDAO.updateWerkUren(task);
    }

    public int deleteWerkUren(int id) {
        return werkUrenDAO.deleteWerkUren(id);
    }
}
