package com.example.ecommerce.controller;


import com.example.ecommerce.service.CheckOutService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CheckOutController {

    private final CheckOutService checkOutService;
    @GetMapping("/checkOut/{userId}")
    public ResponseEntity<?> checkOut(@PathVariable Long userId){
        return checkOutService.checkOut(userId);
    }

}
