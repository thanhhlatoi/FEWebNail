package com.example.API.service.Imlp;

import com.example.API.dto.request.CustomerCreateRequest;
import com.example.API.entity.Customer;
import com.example.API.exception.NotFoundException;
import com.example.API.repository.CustomerRepository;
import com.example.API.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CustomerServiceImlp implements CustomerService {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        List<Customer> list = customerRepository.findAll(Sort.by("customerID").descending());
        return list;
    }

    @Override
    public List<Customer> getListEnabled() {
        return List.of();
    }

    @Override
    public Customer createCustomer(CustomerCreateRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setBirthDay(request.getBirthDay());
        customer.setEnabled(request.isEnabled());
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Integer customerID, CustomerCreateRequest request) {
        Customer customer = customerRepository.findById(customerID).orElseThrow(() -> new NotFoundException("Not Found Category With Id: " + customerID));
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setBirthDay(request.getBirthDay());
        customer.setEnabled(request.isEnabled());
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void enableCustomer(Integer customerID) {

    }

    @Override
    public void deleteCustomer(Integer customerID) {
        Customer customer = customerRepository.findById(customerID).orElseThrow(() -> new NotFoundException("Not Found Custommer With Id: " + customerID ));
        customerRepository.delete(customer);
    }
}
