package sr.unasat.dao;

import sr.unasat.configuration.JPAConfig;
import sr.unasat.entity.Afdeling;
import sr.unasat.entity.Functie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class FunctieDAO {
    private EntityManager entityManager = JPAConfig.getEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    public List<Functie> findAllFuncties(){
        if (!transaction.isActive()){
            transaction.begin();
        }
        String jpql = "select f from Functie f";
        TypedQuery<Functie> query = entityManager.createQuery(jpql, Functie.class);
        List<Functie> functieList = query.getResultList();
        transaction.commit();

        return functieList;
    }

    public Functie findFunctieById(int id) {
        transaction.begin();
        String jpql = "select f from Functie f where f.functieId = :id";
        TypedQuery<Functie> query = entityManager.createQuery(jpql, Functie.class);
        Functie functie = query.setParameter("id", id).getSingleResult();
        transaction.commit();
        return functie;
    }

    public Functie insertFunctie(Functie functie) {
        transaction.begin();
        entityManager.persist(functie);
        transaction.commit();
        return functie;
    }

    public int updateFunctie(Functie functie) {
        transaction.begin();
        String jpql = "update Functie f set f.functieType = :functieType where f.functieId = :id";
        TypedQuery<Afdeling> query = entityManager.createQuery(jpql, Afdeling.class);
        query.setParameter("functieType", functie.getFunctieType());
        query.setParameter("id", functie.getFunctieId());
        int rowsUpdated = query.executeUpdate();
        transaction.commit();
        return rowsUpdated;
    }

    public int deleteFunctie(int id) {
        if (!transaction.isActive()){
            transaction.begin();
        }
        String functiejpql = "delete from Afdeling a where a.afdelingId = :id";
        Query FunctieQuery = entityManager.createQuery(functiejpql);
        String jpql = "delete from Functie f where f.functieId = :id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("id", id);
        int rowsDeleted = query.executeUpdate();

        System.out.println("row deleted"+rowsDeleted);
        transaction.commit();
        return rowsDeleted;

    }
}
