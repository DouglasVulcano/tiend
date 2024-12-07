package com.tiend.domain.port.input;

import java.util.Optional;

import com.tiend.domain.model.User;

public interface UserService {
    User createUser(User user);

    Optional<User> getUserById(Long id);
}