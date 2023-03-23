package sr.unasat.service;

import sr.unasat.dao.FunctieDAO;
import sr.unasat.entity.Functie;

import java.util.List;

public class FunctieService {
    private FunctieDAO functieDAO = new FunctieDAO();

    public List<Functie> findAllFunctie() {
        return functieDAO.findAllFuncties();
    }

    public Functie findFunctieById(int id) {
        return functieDAO.findFunctieById(id);
    }

    public Functie insertFunctie(Functie functie) {
        return functieDAO.insertFunctie(functie);
    }

    public int updateFunctie(Functie functie) {
        return functieDAO.updateFunctie(functie);
    }

    public int deleteFunctie(int id) {
        return functieDAO.deleteFunctie(id);
    }
}
