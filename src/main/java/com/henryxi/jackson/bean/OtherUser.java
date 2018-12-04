package com.henryxi.jackson.bean;

import java.io.Serializable;

public class OtherUser implements Serializable{

    private static final long serialVersionUID = -3410732585064865893L;
    private String name;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
