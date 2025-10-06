package com.example.ecommerce.service;


import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.model.Orders;
import com.example.ecommerce.model.Status;
import com.example.ecommerce.repo.CartRepo;
import com.example.ecommerce.repo.OrdersRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CheckOutService {

    private final CartRepo cartRepo;
    private final OrdersRepo ordersRepo;
    @Transactional
    public ResponseEntity<?> checkOut(Long userId) {
        List<Cart> cartItems=cartRepo.findAllByUserId(userId);
        List<OrderItem> orderItems=new ArrayList<>();
        double total=0;
        for(Cart cart : cartItems){
            OrderItem orderItem= OrderItem.builder().
                                productId(cart.getProductId())
                                .amount(cart.getAmount())
                                .quantity(cart.getQuantity())
                                .build();
            orderItems.add(orderItem);
            total+= cart.getAmount();
        }
        Orders orders=Orders.builder()
                .userId(userId)
                .orderItemList(orderItems)
                .totalAmount(total)
                .status(Status.PENDING)
                .build();
        ordersRepo.save(orders);
        return ResponseEntity.ok("Order Placed");
    }
}
