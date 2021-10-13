package com.example.bdsapigateway.repository;

import com.example.bdsapigateway.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
