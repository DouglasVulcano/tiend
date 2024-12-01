package com.tiend.adapter.output.persistence.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiend.adapter.output.entities.JpaUserEntity;

@Repository
public interface JpaUserRepository extends JpaRepository<JpaUserEntity, Long> {
    Optional<JpaUserEntity> findByEmail(String email);
}
