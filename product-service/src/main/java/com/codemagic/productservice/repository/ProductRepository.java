package com.codemagic.productservice.repository;

import com.codemagic.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByProductName(String productName);
}
