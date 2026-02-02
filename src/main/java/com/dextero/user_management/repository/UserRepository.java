package com.dextero.user_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dextero.user_management.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
