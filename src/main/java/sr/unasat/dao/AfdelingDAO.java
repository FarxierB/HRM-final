package sr.unasat.dao;


import sr.unasat.configuration.JPAConfig;
import sr.unasat.entity.Afdeling;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class AfdelingDAO {

    private EntityManager entityManager = JPAConfig.getEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    public List<Afdeling> findAllAfdelingen(){
        if (!transaction.isActive()){
            transaction.begin();
        }
        String jpql = "select a from Afdeling a";
        TypedQuery<Afdeling> query = entityManager.createQuery(jpql, Afdeling.class);
        List<Afdeling> afdelingList = query.getResultList();
        transaction.commit();

        return afdelingList;
    }

    public Afdeling findAfdelingById(int id) {
        transaction.begin();
        String jpql = "select a from Afdeling a where a.afdelingId = :id";
        TypedQuery<Afdeling> query = entityManager.createQuery(jpql, Afdeling.class);
        Afdeling afdeling = query.setParameter("id", id).getSingleResult();
        transaction.commit();
        return afdeling;
    }

    public Afdeling insertAfdeling(Afdeling afdeling) {
        transaction.begin();
        entityManager.persist(afdeling);
        transaction.commit();
        return afdeling;
    }

    public int updateAfdeling(Afdeling afdeling) {
        transaction.begin();
        String jpql = "update Afdeling a set a.afdelingNaam = :afdelingNaam where a.afdelingId = :id";
        TypedQuery<Afdeling> query = entityManager.createQuery(jpql, Afdeling.class);
        query.setParameter("afdelingNaam", afdeling.getAfdelingNaam());
        query.setParameter("id", afdeling.getAfdelingId());
        int rowsUpdated = query.executeUpdate();
        transaction.commit();
        return rowsUpdated;
    }

    public int deleteAfdeling(int id) {
        if (!transaction.isActive()){
            transaction.begin();
        }
        String afdelingjpql = "delete from Afdeling a where a.afdelingId = :id";
        Query AfdelingQuery = entityManager.createQuery(afdelingjpql);
        String jpql = "delete from Afdeling a where a.afdelingId = :id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("id", id);
        int rowsDeleted = query.executeUpdate();

        System.out.println("row deleted"+rowsDeleted);
        transaction.commit();
        return rowsDeleted;

    }
}
