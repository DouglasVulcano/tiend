package com.tiend.adapter.output.services;

import org.springframework.stereotype.Service;

import com.tiend.domain.model.User;
import com.tiend.domain.port.input.UserService;
import com.tiend.domain.port.output.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

}
