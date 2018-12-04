package com.henryxi.jackson.bean;

import java.io.Serializable;
import java.util.List;

public class WrapUser<T> implements Serializable {

    private static final long serialVersionUID = 5875281436091704220L;
    private String name;
    private List<T> users;

    public List<T> getUsers() {
        return users;
    }

    public void setUsers(List<T> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
