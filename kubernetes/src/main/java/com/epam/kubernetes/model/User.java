package com.epam.kubernetes.model;

public class User {

    private String firstName;
    private String lastName;
    private String version;

    public User() {
    }

    public User(String firstName, String lastName, String version) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
