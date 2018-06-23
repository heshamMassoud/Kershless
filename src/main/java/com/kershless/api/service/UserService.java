package com.kershless.api.service;

import com.kershless.api.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(final User user);

    List<User> getAll();

    Optional<User> getById(final String id);

    Optional<User> getByEmail(final String email);

    Optional<User> update(final String id, final User user);

    Optional<User> deleteById(final String id);
}
