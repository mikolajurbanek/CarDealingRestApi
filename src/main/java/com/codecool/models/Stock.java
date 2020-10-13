package com.codecool.models;

import javax.lang.model.element.Element;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Iterator;
import java.util.List;

public class Stock {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("carsPU");
    EntityManager em = emf.createEntityManager();


    public List<Car> getCars() {
        return em.createQuery("SELECT NEW Car(c.year, c.id, c.automat_gear, c.dealer_id, c.model, c.color, c.brand) " +
                "FROM Car c", Car.class).getResultList();
    }




}
