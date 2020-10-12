package com.codecool.models;

public class Car {

    private int year;
    private int id;
    private boolean gearAutomat;
    private int dealerID;
    private String model;
    private String color;
    private String brand;

    public Car(int year, int id, boolean gearAutomat, int dealerID, String model, String color, String brand) {
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
