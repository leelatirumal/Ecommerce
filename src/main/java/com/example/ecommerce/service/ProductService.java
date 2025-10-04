package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductRequest;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    public void addProduct(ProductRequest productRequest) {
        Product p=Product.builder().
                productId(productRequest.getProductId()).
                productName(productRequest.getProductName()).
                amount(productRequest.getAmount()).
                quantity(productRequest.getQuantity()).
                build();
        productRepo.save(p);

    }


    public ResponseEntity<?> allProducts() {

        List<Product> productList=productRepo.findAll();
        return ResponseEntity.ok(productList);
    }
}
