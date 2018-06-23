package com.kershless.api.model;

import org.junit.Test;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserBuilderTest {

    @Test
    public void of_WithNonBlankNames_ShouldCreateBuilderWithFirstNameAndLastNameAndEmail() {
        final UserBuilder userBuilder = UserBuilder.of("foo", "bar", "foobar@gmail.com");

        assertThat(userBuilder.getFirstName()).isEqualTo("foo");
        assertThat(userBuilder.getLastName()).isEqualTo("bar");
        assertThat(userBuilder.getEmail()).isEqualTo("foobar@gmail.com");
        assertThat(userBuilder.getDateOfBirth()).isNull();
        assertThat(userBuilder.getPlaceOfBirth()).isNull();
    }

    @Test
    public void of_WithBlankFirstName_ShouldThrowError() {
        assertThatThrownBy(() -> UserBuilder.of(null, "bar", "foobar@gmail.com"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("First Name is a required field in UserBuilder.");

        assertThatThrownBy(() -> UserBuilder.of("", "bar", "foobar@gmail.com"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("First Name is a required field in UserBuilder.");
    }

    @Test
    public void of_WithBlankLastName_ShouldThrowError() {
        assertThatThrownBy(() -> UserBuilder.of("foo", null, "foobar@gmail.com"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Last Name is a required field in UserBuilder.");


        assertThatThrownBy(() -> UserBuilder.of("foo", "", "foobar@gmail.com"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Last Name is a required field in UserBuilder.");
    }

    @Test
    public void of_WithBlankEmail_ShouldThrowError() {
        assertThatThrownBy(() -> UserBuilder.of("foo", "foo", null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Email is a required field in UserBuilder.");


        assertThatThrownBy(() -> UserBuilder.of("foo", "foo", ""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Email is a required field in UserBuilder.");
    }

    @Test
    public void dateOfBirth_WithDate_ShouldSetBuilderDateOfBirth() {
        final UserBuilder userBuilder = UserBuilder.of("foo", "bar", "foobar@gmail.com");
        final Date currentDate = Date.from(Instant.now());

        final UserBuilder userBuilderWithDob = userBuilder.dateOfBirth(currentDate);

        assertThat(userBuilder).isSameAs(userBuilderWithDob);
        assertThat(userBuilder.getFirstName()).isEqualTo("foo");
        assertThat(userBuilder.getLastName()).isEqualTo("bar");
        assertThat(userBuilder.getEmail()).isEqualTo("foobar@gmail.com");
        assertThat(userBuilder.getDateOfBirth()).isSameAs(currentDate);
        assertThat(userBuilder.getPlaceOfBirth()).isNull();
    }

    @Test
    public void placeOfBirth_WithBirthPlace_ShouldSetBuilderPlaceOfBirth() {
        final UserBuilder userBuilder = UserBuilder.of("foo", "bar", "foobar@gmail.com");
        final String placeOfBirth = "Cairo";

        final UserBuilder userBuilderWithPob = userBuilder.placeOfBirth(placeOfBirth);

        assertThat(userBuilder).isSameAs(userBuilderWithPob);
        assertThat(userBuilder.getFirstName()).isEqualTo("foo");
        assertThat(userBuilder.getLastName()).isEqualTo("bar");
        assertThat(userBuilder.getEmail()).isEqualTo("foobar@gmail.com");
        assertThat(userBuilder.getDateOfBirth()).isNull();
        assertThat(userBuilder.getPlaceOfBirth()).isEqualTo(placeOfBirth);
    }

    @Test
    public void build_Normally_ShouldCreateAUserBuilderValues() {
        final UserBuilder userBuilder = UserBuilder.of("foo", "bar", "foobar@gmail.com");

        final User user = userBuilder.build();

        assertThat(user).isNotNull();
        assertThat(user.getFirstName()).isEqualTo("foo");
        assertThat(user.getLastName()).isEqualTo("bar");
        assertThat(user.getEmail()).isEqualTo("foobar@gmail.com");
    }
}
