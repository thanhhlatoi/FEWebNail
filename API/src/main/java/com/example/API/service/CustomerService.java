package com.example.API.service;

import com.example.API.dto.request.CustomerCreateRequest;
import com.example.API.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    List<Customer> getListEnabled();

    Customer createCustomer(CustomerCreateRequest request);

    Customer updateCustomer(Integer customerID,CustomerCreateRequest request);

    void enableCustomer(Integer customerID);

    void deleteCustomer(Integer customerID);
}
