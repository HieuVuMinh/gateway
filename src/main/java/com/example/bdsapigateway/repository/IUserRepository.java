package com.example.bdsapigateway.repository;

import com.example.bdsapigateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
