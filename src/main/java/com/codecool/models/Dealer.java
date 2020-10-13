package com.codecool.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dealers")
public class Dealer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String location;
    private String phoneNumber;
    @OneToMany(mappedBy = "dealer")
    private List<Car> dealerCars = new ArrayList<>();

    public Dealer(int id, String name, String location, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Car> getDealerCars() {
        return dealerCars;
    }

    public void setDealerCars(List<Car> dealerCars) {
        this.dealerCars = dealerCars;
    }
}
