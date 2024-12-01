package com.tiend.adapter.output.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.tiend.adapter.input.dto.RegisterRequestDto;
import com.tiend.domain.model.User;
import com.tiend.domain.port.input.AuthService;
import com.tiend.domain.port.output.UserRepository;
import com.tiend.infra.security.PasswordEncoderImpl;
import com.tiend.infra.security.TokenManager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoderImpl passwordEncoderImpl;
    private final TokenManager tokenManager;

    @Override
    public String authenticate(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return tokenManager.generateToken(user);
    }

    @Override
    public String register(RegisterRequestDto data) {
        User newUser = createAndSaveUser(data);
        return tokenManager.generateToken(newUser);
    }

    private User createAndSaveUser(RegisterRequestDto data) {
        return userRepository.save(new User(
                null,
                data.username(),
                data.email(),
                passwordEncoderImpl.encode(data.password()),
                LocalDateTime.now()));
    }

}