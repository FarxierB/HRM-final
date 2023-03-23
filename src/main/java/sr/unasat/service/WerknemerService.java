package sr.unasat.service;

import sr.unasat.dao.WerknemerDAO;
import sr.unasat.entity.Werknemer;

import java.util.List;

public class WerknemerService {
    private WerknemerDAO werknemerDAO = new WerknemerDAO();

    public List<Werknemer> findAllWerknemer() {
        return werknemerDAO.findAllWerknemers();
    }

    public Werknemer findWerknemerById(int id) {
        return werknemerDAO.findWerknemerById(id);
    }

    public Werknemer finWerknemerByAchterNaam(String achternaam){
        return werknemerDAO.findWerknemerByAchternaam(achternaam);
    }

    public Werknemer insertWerknemer(Werknemer werknemer) {
        return werknemerDAO.insertWerknemer(werknemer);
    }

    public int updateWerknemer(Werknemer werknemer) {
        return werknemerDAO.updateWerknemer(werknemer);
    }

    public int deleteWerknemer(int id) {
        return werknemerDAO.deleteWerknemer(id);
    }
}
