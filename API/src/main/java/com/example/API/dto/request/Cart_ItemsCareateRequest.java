package com.example.API.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart_ItemsCareateRequest {
    private int quantity;
    private Integer cartID;
    private Integer productID;
}
