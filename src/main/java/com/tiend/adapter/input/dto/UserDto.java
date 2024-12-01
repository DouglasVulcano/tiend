package com.tiend.adapter.input.dto;

public record UserDto(
        Long id,
        String username,
        String email,
        String createdAt) {

}
