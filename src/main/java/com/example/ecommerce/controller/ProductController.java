package com.example.ecommerce.controller;


import com.example.ecommerce.dto.ProductRequest;
import com.example.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping("/addProduct")
    public String addProduct(@RequestBody ProductRequest productRequest){
        productService.addProduct(productRequest);
        return "done";
    }


    @GetMapping("/allProducts")
    public ResponseEntity<?> allProducts(){
        return productService.allProducts();
    }
}
