package com.henryxi.jackson.bean;

public class Address {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean detectNormal() {
        return true;
    }
}
