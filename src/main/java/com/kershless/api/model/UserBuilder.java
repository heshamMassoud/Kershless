package com.kershless.api.model;


import com.kershless.api.util.Assert;

import java.util.Date;

public class UserBuilder {
    private final String firstName;
    private final String lastName;
    private Date dateOfBirth;
    private String placeOfBirth;
    private final String email;

    private UserBuilder(String firstName, String lastName, Date dateOfBirth, String placeOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.email = email;
    }

    public static UserBuilder of(final String firstName, final String lastName, final String email){
        Assert.notBlank(firstName, "First Name is a required field in UserBuilder.");
        Assert.notBlank(lastName, "Last Name is a required field in UserBuilder.");
        Assert.notBlank(email, "Email is a required field in UserBuilder.");
        return new UserBuilder(firstName, lastName, null, null, email);
    }

    public UserBuilder dateOfBirth(final Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public UserBuilder placeOfBirth(final String placeOfBirth){
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    public User build(){
        return new User(this.firstName, this.lastName, this.dateOfBirth, this.placeOfBirth, this.email);
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
