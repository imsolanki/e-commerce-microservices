package com.codemagic.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="orders")
public class Order {
    @Id
    private String orderId;
    private String productName;
    private int qty;
    private double price;
}
