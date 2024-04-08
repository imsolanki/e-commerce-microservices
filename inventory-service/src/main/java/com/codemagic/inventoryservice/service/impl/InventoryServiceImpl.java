package com.codemagic.inventoryservice.service.impl;

import com.codemagic.inventoryservice.dto.InventoryDto;
import com.codemagic.inventoryservice.entity.Inventory;
import com.codemagic.inventoryservice.exception.ProductAlreadyExistException;
import com.codemagic.inventoryservice.repository.InventoryRepository;
import com.codemagic.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepository inventoryRepository;
    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    @Override
    public Boolean findByProductName(String productName) {
        Optional<Inventory> optionalInventory = Optional.ofNullable(inventoryRepository.
                findByProductName(productName));

        return optionalInventory.isPresent();
    }

    @Override
    public InventoryDto createInventory(InventoryDto inventoryDto) {
        Optional<Inventory> inventory = Optional.ofNullable(inventoryRepository.findByProductName
                (inventoryDto.getProductName()));
        if(inventory.isPresent()){
            throw new ProductAlreadyExistException("Product Already Present!!");
        }
        Inventory inventory1 =dtoToEntity(inventoryDto);
        inventoryRepository.save(inventory1);
        return entityToDto(inventory1);
    }

    private InventoryDto entityToDto(Inventory inventory){
        return new InventoryDto(
                inventory.getId(),
                inventory.getProductName(),
                inventory.getQuantity()
        );
    }

    private Inventory dtoToEntity(InventoryDto inventoryDto){
        return new Inventory(
                inventoryDto.getId(),
                inventoryDto.getProductName(),
                inventoryDto.getQuantity()
        );
    }
}
