package com.tiend.adapter.input.mappers;

import com.tiend.adapter.input.dto.UserDto;
import com.tiend.domain.model.User;

public class UserDtoMapper {

    public static UserDto toDto(User user) {
        if (user == null) {
            return null;
        }

        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt().toString());
    }

    public static User toDomain(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        return new User(
                userDto.id(),
                userDto.username(),
                userDto.createdAt(),
                null,
                null);
    }
}