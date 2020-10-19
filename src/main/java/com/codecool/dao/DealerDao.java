package com.codecool.dao;

import com.codecool.models.Dealer;
import com.codecool.models.dto.DealerDTO;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DealerDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("carsPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    public List<Dealer> getAllDealers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Dealer> cq = cb.createQuery(Dealer.class);
        Root<Dealer> rootEntry = cq.from(Dealer.class);
        CriteriaQuery<Dealer> all = cq.select(rootEntry);
        TypedQuery<Dealer> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public Dealer getDealerById(long dealerID) {
        return em.find(Dealer.class, dealerID);
    }

    public void deleteDealer(long dealerID) {
        Dealer dealer = em.find(Dealer.class, dealerID);
        transaction.begin();
        em.remove(dealer);
        transaction.commit();
    }

    public void addDealer(Dealer dealer) {
        transaction.begin();
        em.persist(dealer);
        transaction.commit();
    }
}
