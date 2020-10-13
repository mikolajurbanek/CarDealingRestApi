package com.codecool.models;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;
    private String brand;
    private String model;
    private int year;
    private boolean gearAutomat;
    private String color;

    public Car(int id, Dealer dealer, String brand, String model, int year, boolean gearAutomat, String color) {
        this.id = id;
        this.dealer = dealer;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.gearAutomat = gearAutomat;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isGearAutomat() {
        return gearAutomat;
    }

    public void setGearAutomat(boolean gearAutomat) {
        this.gearAutomat = gearAutomat;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
