package com.kershless.api.model;


import com.kershless.api.util.Assert;

import java.util.Date;

public final class UserBuilder {
    private final String firstName;
    private final String lastName;
    private final String email;
    private Date dateOfBirth;
    private String placeOfBirth;

    private UserBuilder(final String firstName, final String lastName, final Date dateOfBirth,
                        final String placeOfBirth, final String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.email = email;
    }

    /**
     * Creates an instance of {@link UserBuilder} with the supplied first name, last name and email. If any of these 3
     * fields are supplied blank (more info about what blank means here: {@link Assert#notBlank(String, String)}), an
     * {@link IllegalArgumentException} is thrown.
     *
     * @param firstName the first name to create a {@link UserBuilder} instance with.
     * @param lastName  the last name to create a {@link UserBuilder} instance with.
     * @param email     the email to create a {@link UserBuilder} instance with.
     * @return an instance of {@link UserBuilder} with the supplied first name, last name and email.
     * @throws IllegalArgumentException if the string is {@code null} or blank.
     */
    public static UserBuilder of(final String firstName, final String lastName, final String email) {
        Assert.notBlank(firstName, "First Name is a required field in UserBuilder.");
        Assert.notBlank(lastName, "Last Name is a required field in UserBuilder.");
        Assert.notBlank(email, "Email is a required field in UserBuilder.");
        return new UserBuilder(firstName, lastName, null, null, email);
    }

    public UserBuilder dateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public UserBuilder placeOfBirth(final String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    public User build() {
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
