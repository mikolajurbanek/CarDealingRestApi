package com.codecool.models;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name="dealer_id")
    private Dealer dealer_id;
    private int year;
    private String model;
    private String brand;
    private String color;
    @Column(name="automat_gear")
    private boolean automatGear;
    @ManyToMany(mappedBy = "cars")
    private Set<User> users = new HashSet<>();

    public Car() {

    }

    public Car(Dealer dealer_id, int year, String model, String brand, String color, boolean automatGear) {
        this.dealer_id = dealer_id;
        this.year = year;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.automatGear = automatGear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAutomatGear() {
        return automatGear;
    }

    public void setAutomatGear(boolean automat_gear) {
        this.automatGear = automatGear;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Dealer getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(Dealer dealer_id) {
        this.dealer_id = dealer_id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
