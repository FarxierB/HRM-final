package sr.unasat.dao;

import sr.unasat.configuration.JPAConfig;
import sr.unasat.entity.WerkUren;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class WerkUrenDAO {
    private EntityManager entityManager = JPAConfig.getEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    public List<WerkUren> findAllWerkUren() {
        transaction.begin();
        String jpql = "select w from WerkUren w";
        TypedQuery<WerkUren> query = entityManager.createQuery(jpql, WerkUren.class);
        List<WerkUren> taskList = query.getResultList();
        transaction.commit();
        return taskList;
    }

    public WerkUren findWerkUrenById(int id) {
        transaction.begin();
        String jpql = "select w from WerkUren w where w.werkurenId = :id";
        TypedQuery<WerkUren> query = entityManager.createQuery(jpql, WerkUren.class);
        query.setParameter("id", id);
        WerkUren werkUren = query.getSingleResult();
        transaction.commit();
        return werkUren;
    }

    public WerkUren insertWerkUren(WerkUren werkUren) {
        transaction.begin();
        entityManager.persist(werkUren);
        transaction.commit();
        return werkUren;
    }

    public int updateWerkUren(WerkUren werkUren) {
        transaction.begin();
        String jpql = "update WerkUren w set w.maand = :maand, w.gewerkteUren = :gewerkteUren, w.uurLoon = :uurLoon where w.werkurenId = :id";
        TypedQuery<WerkUren> query = entityManager.createQuery(jpql, WerkUren.class);
        query.setParameter("maand", werkUren.getMaand());
        query.setParameter("gewerkteUren", werkUren.getGewerkteUren());
        query.setParameter("uurLoon", werkUren.getUurLoon());
        query.setParameter("id", werkUren.getWerkurenId());
        int rowsUpdated = query.executeUpdate();
        transaction.commit();
        return rowsUpdated;
    }

    public int deleteWerkUren(int id) {
        transaction.begin();
        String jpql = "delete from WerkUren w where w.werkurenId = :id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("id", id);
        int rowsDeleted = query.executeUpdate();
        transaction.commit();
        return rowsDeleted;
    }


}
