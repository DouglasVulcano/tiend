package com.tiend.domain.port.input;

import com.tiend.adapter.input.dto.RegisterRequestDto;

public interface AuthService {

    public String authenticate(String email, String password);

    public String register(RegisterRequestDto user);

}