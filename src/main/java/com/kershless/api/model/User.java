package com.kershless.api.model;

import java.util.Date;

public class User {
    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;
    private final String placeOfBirth;
    private final String email;

    User(String firstName, String lastName, Date dateOfBirth, String placeOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getEmail() {
        return email;
    }
}
