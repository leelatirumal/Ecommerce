package com.example.ecommerce.repo;

import com.example.ecommerce.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders,Long> {
}
