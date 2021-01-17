package org.kodluyoruz.mvc;

import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private int age;

    public User(UUID id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
