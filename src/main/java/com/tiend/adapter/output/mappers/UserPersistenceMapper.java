package com.tiend.adapter.output.mappers;

import com.tiend.adapter.output.entities.JpaUserEntity;
import com.tiend.domain.model.User;

public class UserPersistenceMapper {

    public static JpaUserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }

        return new JpaUserEntity(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getCreatedAt());
    }

    public static User toDomain(JpaUserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getCreatedAt());
    }
}
