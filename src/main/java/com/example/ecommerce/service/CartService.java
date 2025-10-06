package com.example.ecommerce.service;

import com.example.ecommerce.dto.CartRequest;
import com.example.ecommerce.model.Cart;
import com.example.ecommerce.repo.CartRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {

    public final CartRepo cartRepo;

    public void addToCart(CartRequest cartRequest) {

        Cart cart=Cart.builder().
                userId(cartRequest.getUserId())
                .productId(cartRequest.getProductId())
                .quantity(cartRequest.getQuantity())
                .build();
        cartRepo.save(cart);

    }
}
