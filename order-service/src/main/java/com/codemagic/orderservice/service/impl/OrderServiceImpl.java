package com.codemagic.orderservice.service.impl;

import com.codemagic.orderservice.dto.OrderDto;
import com.codemagic.orderservice.dto.OrderEvent;
import com.codemagic.orderservice.entity.Order;
import com.codemagic.orderservice.exception.ResourceNotFoundException;
import com.codemagic.orderservice.repository.OrderRepository;
import com.codemagic.orderservice.service.APIClient;
import com.codemagic.orderservice.service.OrderService;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private NewTopic topic;
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(Order.class);
    private OrderRepository orderRepository;

    private APIClient apiClient;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,NewTopic topic,
                            KafkaTemplate<String, OrderEvent> kafkaTemplate,
                            APIClient apiClient) {
        this.orderRepository = orderRepository;
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
        this.apiClient=apiClient;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        ResponseEntity<Boolean> input = apiClient.isPresent(orderDto.getProductName());
        LOGGER.info(String.format("Inventory Response -> %s ",input));
        System.out.println(input.toString());
        Boolean booleanValue= input.getBody();
        if (booleanValue != null && booleanValue) {
            Order order1 = dtoToEntity(orderDto);
            order1.setOrderId(UUID.randomUUID().toString());
            orderRepository.save(order1);
            OrderEvent orderEvent = new OrderEvent();
            orderEvent.setStatus("BOOKED");
            orderEvent.setMessage("Order Status is in booked state");
            orderEvent.setOrder(entityToDto(order1));
            sendMessage(orderEvent);

            return new OrderDto(
                    order1.getOrderId(),
                    order1.getProductName(),
                    order1.getQty(),
                    order1.getPrice()
            );
        }
        else {
            //return null;
            throw new ResourceNotFoundException(orderDto.getProductName(), orderDto.getOrderId(), "price");
        }
    }
    private void sendMessage(OrderEvent orderEvent){
        LOGGER.info(String.format("Order Event -> %s",orderEvent.toString()));
        Message<OrderEvent> message = MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC,topic.name())
                .build();
        kafkaTemplate.send(message);
    }
    private OrderDto entityToDto(Order order){
        return new OrderDto(
                order.getOrderId(),
                order.getProductName(),
                order.getQty(),
                order.getPrice()
        );
    }

    private Order dtoToEntity(OrderDto order){
        return new Order(
                order.getOrderId(),
                order.getProductName(),
                order.getQty(),
                order.getPrice()
        );
    }
}
