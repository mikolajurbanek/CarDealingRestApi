package com.codecool;

import com.codecool.models.Car;
import com.codecool.models.Dealer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {

    public static void populateDb(EntityManager em) {

        Dealer dealer = new Dealer("Super Cars", "Warszawa", "123456789");
        Car car = new Car(dealer, 2020, "Model 3", "Tesla", "Blue", true);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(dealer);
        em.persist(car);
        transaction.commit();
        System.out.println("\n### Car saved.\n");
    }

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carsPU");
        EntityManager em = emf.createEntityManager();

        populateDb(em);
        em.clear();

        Car foundCar = em.find(Car.class, 1L);
        System.out.println("\n--Found car");
        System.out.println("Brand: " + foundCar.getBrand());
        System.out.println("Model: " + foundCar.getModel());
        System.out.println("ID: " + foundCar.getId());

        em.close();
        emf.close();

    }
}
