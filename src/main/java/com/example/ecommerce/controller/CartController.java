package com.example.ecommerce.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CartController {



    @PostMapping("/addToCart")
    public String addToCart(@RequestBody ){

    }
}
