package sr.unasat.dao;

import sr.unasat.configuration.JPAConfig;
import sr.unasat.entity.Werknemer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class WerknemerDAO {
    private EntityManager entityManager = JPAConfig.getEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    public List<Werknemer> findAllWerknemers() {
        transaction.begin();
        String jpql = "select w from Werknemer w";
        TypedQuery<Werknemer> query = entityManager.createQuery(jpql, Werknemer.class);
        List<Werknemer> werknemerList = query.getResultList();
        transaction.commit();
        return werknemerList;
    }

    public Werknemer findWerknemerById(int id) {
        transaction.begin();
        String jpql = "select w from Werknemer w where w.werknemerId = :id";
        TypedQuery<Werknemer> query = entityManager.createQuery(jpql, Werknemer.class);
        Werknemer werknemer = query.setParameter("id", id).getSingleResult();
        transaction.commit();
        return werknemer;
    }

    public Werknemer findWerknemerByAchternaam(String achternaam) {
        transaction.begin();
        String jpql = "select w from Werknemer w where w.achterNaam = :achternaam";
        TypedQuery<Werknemer> query = entityManager.createQuery(jpql, Werknemer.class);
        Werknemer werknemer = query.setParameter("achternaam", achternaam).getSingleResult();
        transaction.commit();
        return werknemer;
    }

    public Werknemer insertWerknemer(Werknemer werknemer) {
        transaction.begin();
        entityManager.persist(werknemer);
        transaction.commit();
        return werknemer;
    }

    public int updateWerknemer(Werknemer werknemer) {
        transaction.begin();
        String jpql = "update Werknemer w set w.achterNaam = :achterNaam, w.voorNaam = :voorNaam, w.email = :email where w.werknemerId = :id";
        TypedQuery<Werknemer> query = entityManager.createQuery(jpql, Werknemer.class);
        query.setParameter("achterNaam", werknemer.getAchterNaam());
        query.setParameter("voorNaam", werknemer.getVoorNaam());
        query.setParameter("email", werknemer.getEmail());
        query.setParameter("id", werknemer.getWerknemerId());
        int rowsUpdated = query.executeUpdate();
        transaction.commit();
        return rowsUpdated;
    }

    public int deleteWerknemer(int id) {
        transaction.begin();
        String jpql = "delete from Werknemer w where w.werknemerId = :id";
        TypedQuery<Werknemer> query = entityManager.createQuery(jpql, Werknemer.class);
        query.setParameter("id", id);
        int rowsDeleted = query.executeUpdate();
        transaction.commit();
        return rowsDeleted;
    }
}
