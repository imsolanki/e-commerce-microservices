package com.codemagic.orderservice.service;

import com.codemagic.orderservice.dto.OrderDto;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);
}
