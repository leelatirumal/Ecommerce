package com.example.ecommerce.controller;


import com.example.ecommerce.dto.CartRequest;
import com.example.ecommerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CartController {

    public final CartService cartService;

    @PostMapping("/addToCart")
    public String addToCart(@RequestBody CartRequest cartRequest){
        cartService.addToCart(cartRequest);
        return "ok";
    }
}
