package com.example.ecommerce.repo;

import com.example.ecommerce.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Long> {
    Users findByUsername(String username);
}
