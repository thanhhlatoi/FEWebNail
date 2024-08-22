package com.example.API.service.Imlp;

import com.example.API.dto.request.CartCreateRequest;
import com.example.API.dto.request.Cart_ItemsCareateRequest;
import com.example.API.entity.*;
import com.example.API.exception.NotFoundException;
import com.example.API.repository.CartRepository;
import com.example.API.repository.Cart_ItemsRepository;
import com.example.API.repository.CustomerRepository;
import com.example.API.repository.ProductRepository;
import com.example.API.service.CartService;
import com.example.API.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImlp implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private Cart_ItemsRepository cartItemsRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Cart createCart(CartCreateRequest request) {
        Cart cart = new Cart();
        // Tìm kiếm customer theo ID, nếu không thấy thì ném ngoại lệ
        Customer customer = customerRepository.findById(request.getCustomerID())
                .orElseThrow(() -> new NotFoundException("Not Found Customer With Id: " + request.getCustomerID()));
        cart.setCustomer(customer);
        // Khởi tạo danh sách CartItems và thêm vào Cart
        List<Cart_Items> cartItemsList = new ArrayList<>();
        for (Cart_ItemsCareateRequest itemRequest : request.getCartItems()) {
            Cart_Items cartItem = new Cart_Items();
            // Tìm kiếm Product theo ID từ request
            Product product = productRepository.findById(itemRequest.getProductID())
                    .orElseThrow(() -> new NotFoundException("Not Found Product With Id: " + itemRequest.getProductID()));
            // Thiết lập các thuộc tính cho CartItems
            cartItem.setProduct(product);
            cartItem.setQuantity(itemRequest.getQuantity());
            cartItem.setCart(cart);
            // Thêm CartItems vào danh sách
            cartItemsList.add(cartItem);
        }
        // Thiết lập danh sách CartItems cho Cart
        cart.setCartItems(cartItemsList);
        // Tính tổng giá tiền dựa trên các cart items
        long totalPrice = cartItemsList.stream()
                .mapToLong(item -> item.getQuantity() * item.getProduct().getPrice())
                .sum();
        cart.setTotalPrice(totalPrice);
        // Lưu Cart và các CartItems vào cơ sở dữ liệu
        return cartRepository.save(cart);
    }


    @Override
    public Cart updateCart(Integer cartID, CartCreateRequest request) {
        return null;
    }

    @Override
    public List<Cart> getAll() {
        List<Cart> list = cartRepository.findAll(Sort.by("CartID").descending());
        return list;
    }

    @Override
    public void deleteCart(Integer cartID) {

    }
}
