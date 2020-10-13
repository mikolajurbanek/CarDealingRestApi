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
        return em.createQuery("SELECT NEW Car(c.dealer_id, c.year, c.model, c.brand, c.color, c.automat_gear) " +
                "FROM Car c", Car.class).getResultList();
    }




}
