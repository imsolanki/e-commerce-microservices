package com.codemagic.inventoryservice.controller;

import com.codemagic.inventoryservice.dto.InventoryDto;
import com.codemagic.inventoryservice.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
    private InventoryService inventoryService;
    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<InventoryDto> createInventory(@Valid @RequestBody InventoryDto inventoryDto){
        return new ResponseEntity<>(inventoryService.createInventory(inventoryDto), HttpStatus.CREATED);
    }
    @GetMapping("{product-name}")
    public ResponseEntity<Boolean> isPresent(@PathVariable(name = "product-name") String productName){
        return new ResponseEntity<>(inventoryService.findByProductName(productName), HttpStatus.OK);
    }
}
