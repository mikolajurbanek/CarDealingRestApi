package com.codecool.models.dto;

public class DealerDTO {
    private long id;
    private String name;
    private String location;
    private String phoneNumber;

    public DealerDTO(long id, String name, String location, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
