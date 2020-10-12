package com.codecool.models;

public class Car {
    
    private int id;
    private int year;
    private boolean gearAutomat;
    private String model;
    private String color;
    private int dealerID;
    private String brand;

    public Car(int id, int year, boolean gearAutomat, String model, String color, int dealerID, String brand) {
        this.id = id;
        this.year = year;
        this.gearAutomat = gearAutomat;
        this.model = model;
        this.color = color;
        this.dealerID = dealerID;
        this.brand = brand;
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
        return gearAutomat;
    }

    public void setGearID(boolean gearID) {
        this.gearAutomat = gearID;
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

    public int getDealerID() {
        return dealerID;
    }

    public void setDealerID(int dealerID) {
        this.dealerID = dealerID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
