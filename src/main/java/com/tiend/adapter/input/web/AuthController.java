package com.tiend.adapter.input.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiend.adapter.input.dto.LoginRequestDto;
import com.tiend.adapter.input.dto.RegisterRequestDto;
import com.tiend.adapter.output.responses.ApiResponse;
import com.tiend.domain.port.input.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authServicePort;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody @Valid LoginRequestDto body) {
        String token = authServicePort.authenticate(body.email(), body.password());
        return ResponseEntity.ok(ApiResponse.success("Authentication successful", token));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(@RequestBody @Valid RegisterRequestDto body) {
        String token = authServicePort.register(body);
        return ResponseEntity.ok(ApiResponse.success("Registration successful", token));
    }

}