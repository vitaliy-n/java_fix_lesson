package com.cheba00.db.models;

public class Car {
    private String model;
    private Integer id;
    private User owner;

    public Car() {
    }

    public Car(String model, Integer id, User owner) {
        this.model = model;
        this.id = id;
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
