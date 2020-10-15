package com.codecool.dao;

import com.codecool.models.Car;
import com.codecool.models.Dealer;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CarDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("carsPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    public List<Car> findAllCarsWithCriteriaQuery() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Car> cq = cb.createQuery(Car.class);
        Root<Car> rootEntry = cq.from(Car.class);
        CriteriaQuery<Car> all = cq.select(rootEntry);
        TypedQuery<Car> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public Car getCarById(long carID) {
        return em.find(Car.class, carID);
    }

    public void deleteCar(long carID) {
        Car car = em.find(Car.class, carID);
        transaction.begin();
        em.remove(car);
        transaction.commit();
    }

    public void putCar(EntityManager em, long id, String model, String brand, String color, boolean automat_gear, int year) {
        Dealer dealer = em.find(Dealer.class, id);
        Car car = new Car(dealer, year, model, brand, color, automat_gear);
        System.out.println("this is dealer " + dealer);
        transaction.begin();
        em.persist(car);
        transaction.commit();
    }
}
