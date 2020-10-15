package com.codecool.Services;

import com.codecool.models.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;

public class Stock {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("carsPU");
    EntityManager em = emf.createEntityManager();

    public List<Car> getCars() {
        return em.createQuery("SELECT NEW Car(c.dealer_id, c.year, c.model, c.brand, c.color, c.automat_gear) " +
                "FROM Car c", Car.class).getResultList();
    }

    @Transactional
    public void insertWithQuery() {
        SessionFactory factory = new SessionFactory() {
        }
        Session session = factory.openSession();
        Transaction tx;
        Transaction txn = session.beginTransaction();
        em.createNativeQuery("INSERT INTO cars (automat_gear, brand, color,  model, year, dealer_id) VALUES (?,?,?,?,?,?);")
                .setParameter(1, true)
                .setParameter(2, "Opel")
                .setParameter(3, "red")
                .setParameter(4, "Corsa")
                .setParameter(5, "2010")
                .setParameter(6, 1)
                .executeUpdate();
        txn.commit();
    }

}
