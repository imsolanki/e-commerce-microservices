package com.codemagic.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8083",value = "INVENTORY-SERVICE")
public interface APIClient {
    @GetMapping("api/v1/inventory/{product-name}")
    public ResponseEntity<Boolean> isPresent(@PathVariable(name = "product-name") String productName);
}
