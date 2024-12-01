package com.tiend.adapter.output.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.tiend.adapter.output.mappers.UserPersistenceMapper;
import com.tiend.adapter.output.persistence.jpa.JpaUserRepository;
import com.tiend.domain.model.User;
import com.tiend.domain.port.output.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public User save(User user) {
        this.jpaUserRepository.save(UserPersistenceMapper.toEntity(user));
        return user;
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(UserPersistenceMapper.toDomain(this.jpaUserRepository.findById(id).orElse(null)));
    }

    public Optional<User> findByEmail(String email) {
        return Optional
                .ofNullable(UserPersistenceMapper.toDomain(this.jpaUserRepository.findByEmail(email).orElse(null)));
    }

    public List<User> findAll() {
        return this.jpaUserRepository.findAll().stream().map(UserPersistenceMapper::toDomain).toList();
    }

    public void deleteById(Long id) {
        this.jpaUserRepository.deleteById(id);
    }
}
