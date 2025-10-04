package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;

    private String productId;

    private double amount;

    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders order;
}
