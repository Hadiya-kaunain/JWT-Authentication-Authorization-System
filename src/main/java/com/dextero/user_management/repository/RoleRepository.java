package com.dextero.user_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dextero.user_management.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
