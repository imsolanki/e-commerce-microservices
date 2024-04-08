package com.codemagic.inventoryservice.service;

import com.codemagic.inventoryservice.dto.InventoryDto;

public interface InventoryService {
    Boolean findByProductName(String productName);

    InventoryDto createInventory(InventoryDto inventoryDto);
}
