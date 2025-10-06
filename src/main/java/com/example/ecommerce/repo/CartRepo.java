package com.example.ecommerce.repo;

import com.example.ecommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart,Long> {
    List<Cart> findAllByUserId(Long userId);
}
