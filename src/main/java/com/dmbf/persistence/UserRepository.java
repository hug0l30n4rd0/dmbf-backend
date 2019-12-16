package com.dmbf.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmbf.model.ApplicationUser;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}