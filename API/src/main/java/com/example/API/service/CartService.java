package com.example.API.service;

import com.example.API.dto.request.CartCreateRequest;
import com.example.API.dto.request.CategoryCreateRequest;
import com.example.API.entity.Cart;
import com.example.API.entity.Category;

import java.util.List;

public interface CartService {
    Cart createCart (CartCreateRequest request);
    Cart updateCart(Integer cartID,CartCreateRequest request);
    List<Cart> getAll();
    void deleteCart(Integer cartID);
}
