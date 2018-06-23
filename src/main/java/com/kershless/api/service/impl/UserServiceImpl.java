package com.kershless.api.service.impl;

import com.kershless.api.model.User;
import com.kershless.api.model.UserBuilder;
import com.kershless.api.service.UserService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User create(final User user) {
        return user;
    }

    @Override
    public List<User> getAll() {
        final User hesham = UserBuilder
            .of("Hesham", "Massoud", "heshamhamdymassoud@gmail.com")
            .dateOfBirth(Date.from(Instant.now()))
            .placeOfBirth("Cairo")
            .build();

        final User tarek = UserBuilder
            .of("Tarek", "Massoud", "tarekegt@gmail.com")
            .dateOfBirth(Date.from(Instant.now()))
            .placeOfBirth("Cairo")
            .build();

        return Arrays.asList(hesham, tarek);
    }

    @Override
    public Optional<User> getById(final String id) {
        if (id.equals("1")) {
            return Optional.empty();
        }
        return Optional.of(UserBuilder.of("Tarek", "Massoud", "tarergekt@gmail.com")
                                      .dateOfBirth(Date.from(Instant.now()))
                                      .placeOfBirth("Cairo")
                                      .build());
    }

    @Override
    public Optional<User> getByEmail(final String email) {
        return Optional.of(UserBuilder.of("Tarek", "Massoud", "tareergkt@gmail.com")
                                      .dateOfBirth(Date.from(Instant.now()))
                                      .placeOfBirth("Cairo")
                                      .build());
    }

    @Override
    public Optional<User> update(final String id, final User user) {
        return Optional.of(UserBuilder.of("Tarek", "Massoud", "tarekgret@gmail.com")
                                      .dateOfBirth(Date.from(Instant.now()))
                                      .placeOfBirth("Cairo")
                                      .build());
    }

    @Override
    public Optional<User> deleteById(final String id) {
        return Optional.of(UserBuilder.of("Tarek", "Massoud", "tarektgre@gmail.com")
                                      .dateOfBirth(Date.from(Instant.now()))
                                      .placeOfBirth("Cairo")
                                      .build());
    }
}
