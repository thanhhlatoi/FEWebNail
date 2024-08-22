package com.example.API.controller;

import com.example.API.dto.request.CustomerCreateRequest;
import com.example.API.entity.Customer;
import com.example.API.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("list")
    public ResponseEntity<?> getall (){
        List<Customer> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
    }


    @PostMapping("add")
    public ResponseEntity<?> createCustomre(@Valid @RequestBody CustomerCreateRequest request){
        Customer customer = customerService.createCustomer(request);
        return ResponseEntity.ok(customer);
    }
    @PutMapping("update/{customerID}")
    public ResponseEntity<?> updateCustomer(@PathVariable Integer customerID, @Valid @RequestBody CustomerCreateRequest request){
        Customer customer = customerService.updateCustomer(customerID, request);
        return ResponseEntity.ok(customer);
    }
    @DeleteMapping("/delete/{customerID}")
    public ResponseEntity<?> delete(@PathVariable Integer customerID){
        customerService.deleteCustomer(customerID);
        return ResponseEntity.ok("xoa thanh cong");
    }
}
