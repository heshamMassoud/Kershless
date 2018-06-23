package com.kershless.api.model;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    private static User user;

    @BeforeClass
    public static void setUpClass(){
        user = UserBuilder.of("foo", "bar", "foobar@gmail.com")
                          .dateOfBirth(Date.from(Instant.ofEpochSecond(1)))
                          .placeOfBirth("Cairo")
                          .build();
    }

    @Test
    public void getFirstName_normally_ShouldGetFirstName() {
        assertThat(user.getFirstName()).isEqualTo("foo");
    }

    @Test
    public void getLastName_normally_ShouldGetLastName() {
        assertThat(user.getLastName()).isEqualTo("bar");
    }

    @Test
    public void getEmail_normally_ShouldGetEmail() {
        assertThat(user.getEmail()).isEqualTo("foobar@gmail.com");
    }

    @Test
    public void getPlaceOfBirth_normally_ShouldGetPlaceOfBirth() {
        assertThat(user.getPlaceOfBirth()).isEqualTo("Cairo");
    }

    @Test
    public void getDateOfBirth_normally_ShouldGetDateOfBirth() {
        assertThat(user.getDateOfBirth()).isEqualTo(Date.from(Instant.ofEpochSecond(1)));
    }

}
