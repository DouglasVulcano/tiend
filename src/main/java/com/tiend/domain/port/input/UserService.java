package com.tiend.domain.port.input;

import com.tiend.domain.model.User;

public interface UserService {
    User createUser(User user);

    User getUserById(Long id);
}