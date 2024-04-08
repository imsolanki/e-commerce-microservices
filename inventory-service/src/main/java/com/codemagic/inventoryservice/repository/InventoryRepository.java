package com.codemagic.inventoryservice.repository;

import com.codemagic.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    Inventory findByProductName(String productName);

}
