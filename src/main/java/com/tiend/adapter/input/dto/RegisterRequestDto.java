package com.tiend.adapter.input.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequestDto(
        @NotBlank(message = "Name is required") String username,

        @NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email,

        @NotBlank(message = "Password is required") @Size(min = 6, message = "Password should have at least 6 characters") String password,

        @NotBlank(message = "Password confirmation is required") @Size(min = 6, message = "Password confirmation should have at least 6 characters") String confirmPassword) {
}
