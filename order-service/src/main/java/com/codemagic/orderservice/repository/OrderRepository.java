package com.codemagic.orderservice.repository;

import com.codemagic.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
    Order findByProductName(String productName);

}
