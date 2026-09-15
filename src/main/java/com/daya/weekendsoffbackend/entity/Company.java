package com.daya.weekendsoffbackend.entity;

public class Company {
    private Long id;
    private String name;
    private boolean weekendsOff;
    private String city;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getWeekendsOff() {
        return weekendsOff;
    }

    public void setWeekendsOff(boolean weekendsOff) {
        this.weekendsOff = weekendsOff;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
