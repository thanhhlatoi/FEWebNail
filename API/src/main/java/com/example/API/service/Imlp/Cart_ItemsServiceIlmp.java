package com.example.API.service.Imlp;

import com.example.API.dto.request.CartCreateRequest;
import com.example.API.dto.request.Cart_ItemsCareateRequest;
import com.example.API.entity.Cart_Items;
import com.example.API.entity.Product;
import com.example.API.exception.NotFoundException;
import com.example.API.repository.CartRepository;
import com.example.API.repository.Cart_ItemsRepository;
import com.example.API.repository.ProductRepository;
import com.example.API.service.Cart_ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Cart_ItemsServiceIlmp implements Cart_ItemsService {
    @Autowired
    private Cart_ItemsRepository cartItemsRepository;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Cart_Items createCart_Items(Cart_ItemsCareateRequest request) {
        Cart_Items cartItem = new Cart_Items();

        // Tìm kiếm Product theo ID từ request
        Product product = productRepository.findById(request.getProductID())
                .orElseThrow(() -> new NotFoundException("Not Found Product With Id: " + request.getProductID()));

        // Thiết lập các thuộc tính cho CartItems
        cartItem.setProduct(product);
        cartItem.setQuantity(request.getQuantity());

        // Liên kết CartItems với Cart
        cartItem.setCart(cartRepository.findById(request.getCartID())
                .orElseThrow(() -> new NotFoundException("Not Found Cart With Id: " + request.getCartID())));

        // Lưu CartItems vào cơ sở dữ liệu
        return cartItemsRepository.save(cartItem);
    }

    @Override
    public Cart_Items updateCart_Items(Integer cartID, Cart_ItemsCareateRequest request) {
        return null;
    }

    @Override
    public List<Cart_Items> getAll() {
        return List.of();
    }

    @Override
    public void deleteCart_Items(Integer cartID) {

    }
}
