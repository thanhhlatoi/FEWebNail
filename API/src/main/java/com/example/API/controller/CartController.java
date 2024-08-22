package com.example.API.controller;

import com.example.API.dto.request.CartCreateRequest;
import com.example.API.entity.Cart;
import com.example.API.entity.Category;
import com.example.API.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")

public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody CartCreateRequest request) {
        Cart cart = cartService.createCart(request);
        return ResponseEntity.ok(cart);
    }
    @GetMapping("/")
    public ResponseEntity<?> getListCategory(){
        List<Cart> carts = cartService.getAll();
        return ResponseEntity.ok(carts);
    }
}
