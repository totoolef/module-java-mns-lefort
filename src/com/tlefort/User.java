package com.tlefort;

import java.util.UUID;

public class User  {

    private final UUID id = UUID.randomUUID();
    private String firstName;

    public User(String firstName) {
        this.firstName = firstName;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + '}';
    }
}
