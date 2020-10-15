package com.codecool;

import com.codecool.Services.Stock;
import com.codecool.models.Car;
import com.codecool.models.Dealer;
import com.codecool.models.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {

   public static void populateDb(EntityManager em) {

        Dealer dealer = new Dealer("Super Cars", "Warszawa", "123456789");
        Dealer dealer2 = new Dealer("Exclusive Cars", "Kraków", "177756789");
        Dealer dealer3 = new Dealer("Your Dream Car", "Sopot", "851762459");
        Car car = new Car(dealer, 2020, "Model 3", "Tesla", "Blue", true);
        Car car1 = new Car(dealer, 2019, "Supra", "Toyota", "Black", false);
        Car car2 = new Car(dealer, 2018, "Camaro", "Chevrolet", "Yellow", true);
        Car car3 = new Car(dealer2, 2017, "Lancer", "Mitsubishi", "Orange", false);
        Car car4 = new Car(dealer2, 2018, "Camaro", "Chevrolet", "Yellow", true);
        Car car5 = new Car(dealer3, 2020, "A7", "Audi", "Black", true);
        User user = new User("Tomek", "K");

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(dealer);
        em.persist(dealer2);
        em.persist(dealer3);
        em.persist(car);
        em.persist(car1);
        em.persist(car2);
        em.persist(car3);
        em.persist(car4);
        em.persist(car5);
        em.persist(user);
        transaction.commit();
        System.out.println("\n### Car saved.\n");

    }

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carsPU");
        EntityManager em = emf.createEntityManager();
        populateDb(em);
        em.clear();
        em.close();
        emf.close();
    }
}
