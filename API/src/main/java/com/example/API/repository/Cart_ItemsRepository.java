package com.example.API.repository;

import com.example.API.entity.Cart_Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cart_ItemsRepository extends JpaRepository<Cart_Items,Integer> {
}
