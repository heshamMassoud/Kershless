package com.kershless.api.controller;

import com.kershless.api.model.User;
import com.kershless.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    /**
     * Get all users.
     *
     * @return all {@link User}.
     */
    @GetMapping()
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * Get a user by id.
     *
     * @return a {@link User} by id.
     */
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") final String id) {
        return userService.getById(id).orElseThrow(ResourceNotFoundException::new);
    }


    /**
     * Update a user by id.
     *
     * @return updated {@link User} by id.
     */
    @PostMapping("/{id}")
    public User update(@PathVariable("id") final String id, @RequestBody final User user) {
        return userService.update(id, user).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * Delete a user by id.
     *
     * @return deleted {@link User} by id.
     */
    @DeleteMapping("/{id}")
    public User delete(@PathVariable("id") final String id) {
        logger.info("Deleting user!!");
        return userService.deleteById(id).orElseThrow(ResourceNotFoundException::new);
    }

}
