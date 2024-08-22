package com.example.API.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartCreateRequest {
    private long totalPrice;
    private Integer customerID;
    private List<Cart_ItemsCareateRequest> cartItems;
}
