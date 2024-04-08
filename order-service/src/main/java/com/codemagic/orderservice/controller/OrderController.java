package com.codemagic.orderservice.controller;

import com.codemagic.orderservice.dto.OrderDto;
import com.codemagic.orderservice.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public ResponseEntity<OrderDto> placeOrder(@RequestBody @Valid OrderDto orderDto){
        return new ResponseEntity<>(orderService.createOrder(orderDto), HttpStatus.CREATED);
    }
}
