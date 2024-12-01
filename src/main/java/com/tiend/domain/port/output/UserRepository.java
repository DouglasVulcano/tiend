package com.tiend.domain.port.output;

import java.util.List;

import com.tiend.domain.model.User;

public interface UserRepository {
    User save(User user);

    User findById(Long id);

    List<User> findAll();

    void deleteById(Long id);
}
