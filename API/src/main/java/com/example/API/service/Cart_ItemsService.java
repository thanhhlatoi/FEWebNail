package com.example.API.service;

import com.example.API.dto.request.CartCreateRequest;
import com.example.API.dto.request.Cart_ItemsCareateRequest;
import com.example.API.entity.Cart;
import com.example.API.entity.Cart_Items;

import java.util.List;

public interface Cart_ItemsService {
    Cart_Items createCart_Items (Cart_ItemsCareateRequest request);
    Cart_Items updateCart_Items(Integer cartID,Cart_ItemsCareateRequest request);
    List<Cart_Items> getAll();
    void deleteCart_Items(Integer cartItemsID);
}
