package com.example.API.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name = "CustomerID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerID;
//    @Column(name="username",unique = true)
//    private String username;
    @Column(name="email",unique = true)
    private String email;
    @Column(name = "Name")
    private String name;
//    private String password;
    private String phone;
    private LocalDate birthDay;
    private boolean enabled;

}
