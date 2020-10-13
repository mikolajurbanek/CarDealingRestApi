package com.codecool.models;


import javax.persistence.*;

@Entity
@Table(name = "cars")
//@TypeDef(name = "hstore", typeClass = PostgreSQLHStoreType.class)
public class Car {

    private int year;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean automat_gear;
    private int dealer_id;
    private String model;
    private String color;
    private String brand;


    public Car(int year, int id, boolean automat_gear, int dealer_id, String model, String color, String brand) {
        this.id = id;
        this.year = year;
        this.automat_gear = automat_gear;
        this.model = model;
        this.color = color;
        this.dealer_id = dealer_id;
        this.brand = brand;
    }

    public Car() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isGearID() {
        return automat_gear;
    }

    public void setGearID(boolean gearID) {
        this.automat_gear = gearID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(int dealerID) {
        this.dealer_id = dealerID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
